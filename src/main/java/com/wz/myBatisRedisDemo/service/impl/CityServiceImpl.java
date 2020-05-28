package com.wz.myBatisRedisDemo.service.impl;

import com.wz.myBatisRedisDemo.dao.CityMapper;
import com.wz.myBatisRedisDemo.pojo.City;
import com.wz.myBatisRedisDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("CityService")
public class CityServiceImpl implements CityService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCityByName(String cityName) {
        return cityMapper.getCityByName(cityName);
    }

}
