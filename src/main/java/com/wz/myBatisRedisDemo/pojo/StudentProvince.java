package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 学生和省份
 *
 * @author Richa
 * @date 2020/6/1 14:21
 */
@Data
public class StudentProvince implements Serializable {

    private static final Long serialVersionUID = 5L;

    private String id;

    private String studentName;

    private Integer age;

    private String sex;

    private String cityName;

    private String provinceName;
}
