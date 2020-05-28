package com.wz.myBatisRedisDemo.controller;

import com.wz.myBatisRedisDemo.pojo.City;
import com.wz.myBatisRedisDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.GET)
    public City getCityByName(@PathVariable("cityName") String cityName) {
        return cityService.getCityByName(cityName);
    }
}
