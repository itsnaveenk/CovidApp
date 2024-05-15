package com.naveenk.covidapp.controller;


import com.naveenk.covidapp.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data")
public class CovidController {

    @Autowired
    CovidDataService data;

    @GetMapping("/citywise/{city}")
    public String getCovidCases(@PathVariable String city) throws InterruptedException {
        Integer covidData = data.getCovidData(city);
        return "Covid cases in " +city +" = "+ covidData;
    }
}
