package com.wz.myBatisRedisDemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wz.myBatisRedisDemo.dao.StudentMapper;
import com.wz.myBatisRedisDemo.pojo.Student;
import com.wz.myBatisRedisDemo.pojo.StudentProvince;
import com.wz.myBatisRedisDemo.pojo.StudentVO;
import com.wz.myBatisRedisDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page<Student> getStudent(String studentName, Integer age, String sex, String cityName, Integer page, Integer pageSize) {
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName(studentName);
        studentVO.setAge(age);
        studentVO.setSex(sex);
        studentVO.setCityName(cityName);
        PageHelper.startPage(page, pageSize);
        Page<Student> ans = studentMapper.getStudent(studentVO);
        return ans;
    }

    @Override
    public String insertStudent(Student student) {
        studentMapper.insertStudent(student);
        return student.getId();
    }

    @Override
    public void deleteStudent(String studentName) {
        studentMapper.deleteStudent(studentName);
    }

    @Override
    public String updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return student.getId();
    }

    @Override
    public StudentProvince getStudentProvince(String studentName) {
        return studentMapper.getStudentProvince(studentName);
    }
}
