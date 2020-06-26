package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 城市VO
 *
 * @author Richa
 * @date 2020/5/29 14:48
 */
@Data
public class CityVO implements Serializable {

    private static final Long serialVersionUID = 4L;

    private String cityName;

    private String provinceName;
}
