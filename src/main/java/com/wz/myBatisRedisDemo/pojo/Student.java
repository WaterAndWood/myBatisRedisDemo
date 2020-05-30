package com.wz.myBatisRedisDemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 学生DO
 *
 * @author Richa
 * @date 2020/5/30 16:00
 */
@Data
public class Student implements Serializable {
    private String id;

    private String studentName;

    private Integer age;

    private String sex;

    private String cityName;
}
