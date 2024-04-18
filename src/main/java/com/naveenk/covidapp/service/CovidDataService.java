package com.naveenk.covidapp.service;


import com.naveenk.covidapp.utility.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.ObjLongConsumer;

@Service
public class CovidDataService {
@Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName) {

//        HttpComponentsClientHttpRequestFactory requestFactory = (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
//        requestFactory.setConnectTimeout(5000);

        Map<String, Object> map= restTemplate.getForObject(Variables.Covid_Data_API, Map.class);
        System.out.println(map);
        Map<String, Object> cityObject =(Map<String, Object>) map.get("cityName");

        Map<String, Object> dataDistrict =(Map<String, Object>) cityObject.get("districtData");

        Map<String, Object> city =(Map<String, Object>) dataDistrict.get("New Delhi");

        Integer activeCases = (Integer) city.get("active");


        System.out.println(activeCases);
        return 1;
    }

}
