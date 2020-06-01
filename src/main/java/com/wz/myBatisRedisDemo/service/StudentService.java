package com.wz.myBatisRedisDemo.service;

import com.github.pagehelper.Page;
import com.wz.myBatisRedisDemo.pojo.Student;
import com.wz.myBatisRedisDemo.pojo.StudentProvince;
import com.wz.myBatisRedisDemo.pojo.StudentVO;

import java.util.List;

/**
 *
 * 学生增删改查以及和城市的关联查询
 *
 * @author Richa
 * @date 2020/5/30 16:08
 */
public interface StudentService {

    /**
     *
     * 查询student
     * 筛选条件分页
     *
     * @author Richa on 2020/5/30 22:03
     * @param page page
     * @param pageSize pageSize
     * @return
     * @throws
     */
    Page<Student> getStudent(String studentName, Integer age, String sex, String cityName, Integer page, Integer pageSize);

    /**
     *
     * 增加student
     *
     * @author Richa on 2020/5/30 23:18
     * @param student id= null
     * @return
     * @throws
     */
    String insertStudent(Student student);

    /**
     *
     * 修改student
     *
     * @author Richa on 2020/5/30 23:50
     * @param student id=id
     * @return
     * @throws
     */
    String updateStudent(Student student);

    /**
     *
     * description
     *
     * @author Richa on 2020/5/30 23:53
     * @param studentName
     * @return
     * @throws
     */
    void deleteStudent(String studentName);

    /**
     *
     * 学生+省份
     *
     * @author Richa on 2020/5/31 14:56
     * @param studentName 学生名
     * @return
     * @throws
     */
    StudentProvince getStudentProvince(String studentName);
}
