package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    private String id;

    private String cityName;

    private String provinceName;
}
