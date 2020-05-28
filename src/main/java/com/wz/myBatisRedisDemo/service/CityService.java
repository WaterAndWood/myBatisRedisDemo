package com.wz.myBatisRedisDemo.service;

import com.wz.myBatisRedisDemo.pojo.City;

public interface CityService {

    City getCityByName(String cityName);
}
