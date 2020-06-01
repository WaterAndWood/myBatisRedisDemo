package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 城市和学生数
 *
 * @author Richa
 * @date 2020/5/31 10:22
 */
@Data
public class CityStuNumVO implements Serializable {

    private String id;

    private String cityName;

    private String provinceName;

    private String studentNum;
}
