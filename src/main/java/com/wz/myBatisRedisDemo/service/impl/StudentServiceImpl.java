package com.wz.myBatisRedisDemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wz.myBatisRedisDemo.dao.StudentMapper;
import com.wz.myBatisRedisDemo.pojo.Student;
import com.wz.myBatisRedisDemo.pojo.StudentProvince;
import com.wz.myBatisRedisDemo.pojo.StudentVO;
import com.wz.myBatisRedisDemo.redisConfig.RedisTemplateConfig;
import com.wz.myBatisRedisDemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplateConfig redisTemplateConfig;

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
    public void deleteStudent(String id) {
        studentMapper.deleteStudent(id);
        // 缓存存在，则删除缓存
        RedisTemplate<String, Student> redisTemplate = redisTemplateConfig.redisTemplateKeyString();
        String key = "student_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("StudentServiceImpl.deleteStudent : 删除缓存中的学生 >> " + id);
        }
    }

    @Override
    public String updateStudent(Student student) {
        studentMapper.updateStudent(student);
        // 缓存存在，则删除缓存
        RedisTemplate<String, Student> redisTemplate = redisTemplateConfig.redisTemplateKeyString();
        String key = "student_" + student.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("StudentServiceImpl.deleteStudent : 删除缓存中的学生 >> " + student.getStudentName());
        }
        return student.getId();
    }

    @Override
    public StudentProvince getStudentProvince(String studentName) {
        return studentMapper.getStudentProvince(studentName);
    }

    @Override
    public Student getStudentById(String id) {
        RedisTemplate<String, Student> redisTemplate = redisTemplateConfig.redisTemplateKeyString();
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();

        // 缓存中有key
        String key = "student_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey) {
            Student student = operations.get(key);
            logger.info("StudentServiceImpl.getStudentById() : 从缓存中获取了学生 >> " + student.getStudentName());
            return student;
        }
        // 数据库中查询
        Student student = studentMapper.getStudentById(id);
        // 插入缓存
        operations.set(key, student, 180, TimeUnit.SECONDS);
        logger.info("StudentServiceImpl.getStudentById() : 向缓存中插入学生 >> " + student.getStudentName());
        return student;
    }
}
