package com.wz.myBatisRedisDemo.service.impl;

import com.wz.myBatisRedisDemo.dao.CityMapper;
import com.wz.myBatisRedisDemo.pojo.City;
import com.wz.myBatisRedisDemo.pojo.CityStuNumVO;
import com.wz.myBatisRedisDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service("CityService")
public class CityServiceImpl implements CityService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired(required = false)
    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCityByName(String cityName) {
        City city = cityMapper.getCityByName(cityName);
        return city;
    }

    @Override
    public List<City> getCityAll(String provinceName) {
        List<City> ans;
        if (provinceName == null || provinceName.isEmpty()) {
            ans = cityMapper.getCityAll();
        } else {
            ans = cityMapper.getCityAllByProvince(provinceName);
        }
        return ans;
    }

    @Override
    public String insertCity(City city) {
        // mybatis生成uuid主键，并返回主键，dao对象的id为null
        cityMapper.insertCity(city);
        String id = city.getId();
        return id;
    }

    @Override
    public String updateCity(City city) {
        cityMapper.updateCity(city);
        return city.getId();
    }

    @Override
    public void deleteCity(String cityName) {
        cityMapper.deleteCity(cityName);
    }

    @Override
    public List<CityStuNumVO> getCityStuNum(String cityName) {
        return cityMapper.getCityStuNum(cityName);
    }
}
