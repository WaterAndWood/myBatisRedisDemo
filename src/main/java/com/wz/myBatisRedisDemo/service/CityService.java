package com.wz.myBatisRedisDemo.service;

import com.wz.myBatisRedisDemo.pojo.City;
import com.wz.myBatisRedisDemo.pojo.CityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 使用mybatis实现城市的增删改查和student的关联查询
 * 使用形式CityMapper
 *
 * @author Richa
 * @date 2020/5/28 15:58
 */
public interface CityService {

    /**
     *
     * 根据cityName查询城市
     *
     * @author Richa on 2020/5/28 16:00
     * @param cityName 城市名
     * @return
     * @throws
     */
    City getCityByName(@Param("city") String cityName);

    /**
     *
     * 查询全部城市或者根据省份筛选
     * sql查询尽量使用静态，不要动态添加条件参数
     *
     * @author Richa on 2020/5/28 16:01
     * @param provinceName 省份名
     * @return
     * @throws
     */
    List<City> getCityAll(String provinceName);

    /**
     *
     * 新增城市，id前端不传
     *
     * @author Richa on 2020/5/28 17:30
     * @param
     * @return
     * @throws
     */
    String insertCity(City city);

    /**
     *
     * 更改城市
     *
     * @author Richa on 2020/5/29 15:33
     * @param city 城市id和属性
     * @return
     * @throws
     */
    String updateCity(City city);

    /**
     *
     * 删除城市
     *
     * @author Richa on 2020/5/29 15:55
     * @param
     * @return
     * @throws
     */
    void deleteCity(String cityName);
}
