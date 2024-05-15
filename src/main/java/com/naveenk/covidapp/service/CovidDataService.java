package com.naveenk.covidapp.service;


import com.naveenk.covidapp.utility.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CovidDataService {

    @Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName)
    {

        Map<String, String> stateCityMap=new HashMap<>();
        stateCityMap.put("Agra","Uttar Pradesh");
        stateCityMap.put("Rampur","Uttar Pradesh");
        stateCityMap.put("Noida","Uttar Pradesh");
        stateCityMap.put("Hapur","Uttar Pradesh");
        stateCityMap.put("Amritsar","Punjab");
        stateCityMap.put("Barnala","Punjab");
        stateCityMap.put("Bathinda","Punjab");
        stateCityMap.put("Surat","Gujarat");
        stateCityMap.put("Ahmedabad","Gujarat");

        Map<String,Object> map = restTemplate.getForObject(Variables.Covid_Data_API, Map.class);

        Map<String, Object> cityObjectMap = (Map<String, Object>) map.get(stateCityMap.get(cityName));
        Map<String, Object> districtData = (Map<String, Object>) cityObjectMap.get("districtData");
        Map<String, Object> city = (Map<String, Object>) districtData.get(cityName);
        Integer active = (Integer) city.get("active");
        return active;
    }
}
