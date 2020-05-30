package com.wz.myBatisRedisDemo.dao;

import com.wz.myBatisRedisDemo.pojo.City;
import com.wz.myBatisRedisDemo.pojo.CityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.crypto.CipherInputStream;
import java.util.List;

/**
 *
 * 直接使用xml中操作
 * component,该注解是解决IDEA mapper注入时显示could not autowired no bean
 *
 * @author Richa
 * @date 2020/5/28 17:19
 */
@Mapper
@Component(value = "CityMapper")
public interface CityMapper {
    City getCityByName(@Param("cityName") String cityName);

    List<City> getCityAll();

    List<City> getCityAllByProvince(@Param("provinceName") String provinceName);

    void insertCity(City city);

    void updateCity(City city);

    void deleteCity(String cityName);
}
