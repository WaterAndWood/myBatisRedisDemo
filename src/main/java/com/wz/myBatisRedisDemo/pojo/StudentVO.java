package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 学生VO
 *
 * @author Richa
 * @date 2020/5/30 20:18
 */
@Data
public class StudentVO implements Serializable {

    private String studentName;

    private Integer age;

    private String sex;

    private String cityName;
}
