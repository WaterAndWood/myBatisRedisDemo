package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 城市DO
 *
 * @author Richa
 * @date 2020/5/29 14:48
 */
@Data
public class City implements Serializable {

    private static final Long serialVersionUID = 2L;

    private String id;

    private String cityName;

    private String provinceName;
}
