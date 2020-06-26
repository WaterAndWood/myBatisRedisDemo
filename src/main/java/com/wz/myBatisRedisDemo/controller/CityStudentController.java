package com.wz.myBatisRedisDemo.controller;

import com.github.pagehelper.Page;
import com.wz.myBatisRedisDemo.pojo.*;
import com.wz.myBatisRedisDemo.service.CityService;
import com.wz.myBatisRedisDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * 城市和学生操作的controller接口
 * 关联查询：查询学生及其城市对应的省
 * 关联查询：查询城市和对应学生数
 *
 * @author Richa
 * @date 2020/5/28 16:04
 */
@RestController
@RequestMapping(value = "/api")
public class CityStudentController {

    @Autowired
    private CityService cityService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.GET)
    public City getCityByName(@PathVariable("cityName") String cityName) {
        return cityService.getCityByName(cityName);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getCityAll(@RequestParam(name = "provinceName", required = false) String provinceName) {
        return cityService.getCityAll(provinceName);
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public String insertCity(@RequestBody CityVO cityVO) {
        City city = new City();
        city.setCityName(cityVO.getCityName());
        city.setProvinceName(cityVO.getProvinceName());
        return cityService.insertCity(city);
    }

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public String updateCity(@RequestBody  City city) {
        return cityService.updateCity(city);
    }

    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("cityName") String cityName) {
        cityService.deleteCity(cityName);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Page<Student> getStudent(@RequestParam(name = "stuName", required = false) String studentName,
                                    @RequestParam(name = "age", required = false) Integer age,
                                    @RequestParam(name = "sex", required = false) String sex,
                                    @RequestParam(name = "cityName", required = false) String cityName,
                                    @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize) {
        return studentService.getStudent(studentName, age, sex, cityName, page, pageSize);
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String insertStudent(@RequestBody StudentVO studentVO) {
        Student student = new Student();
        student.setSex(studentVO.getSex());
        student.setStudentName(studentVO.getStudentName());
        student.setAge(studentVO.getAge());
        student.setCityName(studentVO.getCityName());
        return studentService.insertStudent(student);
    }

    @RequestMapping(value = "/student/{stuName}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(value = "stuName") String stuName) {
        studentService.deleteStudent(stuName);
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "/city/student", method = RequestMethod.GET)
    public List<CityStuNumVO> getCityStuNum(@RequestParam(name = "cityName", required = false) String cityName) {
        return cityService.getCityStuNum(cityName);
    }

    @RequestMapping(value = "/student/{stuName}/province", method = RequestMethod.GET)
    public StudentProvince getStudentProvince(@PathVariable("stuName") String studentName) {
        return studentService.getStudentProvince(studentName);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable(value = "id") String id) {
        return studentService.getStudentById(id);
    }
}
