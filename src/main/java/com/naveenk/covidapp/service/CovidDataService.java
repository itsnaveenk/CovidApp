//package com.naveenk.covidapp.service;
//
//
//import com.naveenk.covidapp.utility.Variables;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@Service
//public class CovidDataService {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//
//    public long getCovidData(String state)
//    {
//        Map<String,Object> map = restTemplate.getForObject(Variables.Covid_Data_API, Map.class);
//        Map<String, Object> stateData = (Map<String, Object>) map.get(state);
//        Map<String, Object> totalData = (Map<String, Object>) stateData.get("total");
//        long confirmCases = ((Number) totalData.get("confirmed")).longValue();
//
//        return confirmCases;
//    }public long getCovidData(String state, String city)
//    {
//        Map<String,Object> map = restTemplate.getForObject(Variables.Covid_Data_API, Map.class);
//        Map<String, Object> stateData = (Map<String, Object>) map.get(state);
//        Map<String, Object> districtData = (Map<String, Object>) stateData.get("districts");
//        Map<String, Object> cityData = (Map<String, Object>) districtData.get(city);
//        Map<String, Object> totalData = (Map<String, Object>) cityData.get("total");
//        long confirmCases = ((Number) totalData.get("confirmed")).longValue();
//
//        return confirmCases;
//    }
//}
package com.naveenk.covidapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidDataService {

    @Autowired
    CovidDataFetchService dataFetchService;

    public long getCovidData(String state) {
        return dataFetchService.getCachedStateData(state);
    }

    public long getCovidData(String state, String city) {
        return dataFetchService.getCachedCityData(state, city);
    }
}