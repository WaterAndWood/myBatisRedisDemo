package com.wz.myBatisRedisDemo.controller;

import com.wz.myBatisRedisDemo.pojo.City;
import com.wz.myBatisRedisDemo.pojo.CityVO;
import com.wz.myBatisRedisDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * 城市和学生操作的controller接口
 * TODO:
 * 关联查询：查询学生及其城市对应的省
 * 关联查询：查询城市及其学生人数
 * 学生分页查询排序
 * 查询unique城市和省会
 *
 *
 * @author Richa
 * @date 2020/5/28 16:04
 */
@RestController
@RequestMapping(value = "/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.GET)
    public City getCityByName(@PathVariable("cityName") String cityName) {
        return cityService.getCityByName(cityName);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getCityAll(@RequestParam(name = "provinceName", required = false) String provinceName) {
        return cityService.getCityAll(provinceName);
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public String insertCity(@RequestBody CityVO cityVO) {
        City city = new City();
        city.setCityName(cityVO.getCityName());
        city.setProvinceName(cityVO.getProvinceName());
        return cityService.insertCity(city);
    }

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public String updateCity(@RequestBody  City city) {
        return cityService.updateCity(city);
    }

    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("cityName") String cityName) {
        cityService.deleteCity(cityName);
    }


}
