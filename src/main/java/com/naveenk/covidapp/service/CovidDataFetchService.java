package com.naveenk.covidapp.service;

import com.naveenk.covidapp.utility.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class CovidDataFetchService {

    @Autowired
    RestTemplate restTemplate;

    private Map<String, Object> localMap = new HashMap<String, Object>();

    @PostConstruct
    public void init() {
        fetchCovidData();
    }
    @Scheduled(cron = "0 30 1 * * ?")
    public void fetchCovidData() {
        final Map<String,Object> map = restTemplate.getForObject(Variables.Covid_Data_API, Map.class);
        localMap = map;
    }


    public long getCachedStateData(String state) {
        Map<String, Object> Statewise_Data = (Map<String, Object>) localMap.get(state);
        System.out.println(localMap);
        Map<String, Object> total_Data = (Map<String, Object>) Statewise_Data.get("total");
        long confirmCases = ((Number) total_Data.get("confirmed")).longValue();
        return confirmCases;
    }

    public long getCachedCityData(String state, String city) {
        Map<String, Object> Statewise_Data = (Map<String, Object>) localMap.get(state);
        Map<String, Object> Districtwise_Data = (Map<String, Object>) Statewise_Data.get("districts");
        Map<String, Object> districtCases = (Map<String, Object>) Districtwise_Data.get(city);
        Map<String, Object> total_Data = (Map<String, Object>) districtCases.get("total");
        long confirmCases;
        if(total_Data.get("confirmed")==null)
        {
            return 0;
        }
        confirmCases = ((Number) total_Data.get("confirmed")).longValue();
        return confirmCases;
    }
}