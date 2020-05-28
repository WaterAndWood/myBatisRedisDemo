package com.wz.myBatisRedisDemo.dao;

import com.wz.myBatisRedisDemo.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CityMapper {
    City getCityByName(@Param("cityName") String cityName);
}
