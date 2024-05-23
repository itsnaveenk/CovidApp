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

    @GetMapping("/{state}")
    public int getCovidCases(@PathVariable String state) throws InterruptedException {
        long totalCases = data.getCovidData(state);
        return (int) totalCases;
    }

    @GetMapping("/{state}/{city}")
    public int getCovidCases(@PathVariable String state, @PathVariable String city) throws InterruptedException {
        long totalCases = data.getCovidData(state, city);

        return (int) totalCases;
    }
}
