package com.wz.myBatisRedisDemo.dao;

import com.github.pagehelper.Page;
import com.wz.myBatisRedisDemo.pojo.Student;
import com.wz.myBatisRedisDemo.pojo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component(value = "StudentMapper")
public interface StudentMapper {

    Page<Student> getStudent(@Param("studentVO") StudentVO studentVO);

    void insertStudent(Student student);

    void deleteStudent(String studentName);

    void updateStudent(Student student);
}
