package com.hy.mapper;

import com.hy.entity.Student;

import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface StudentMapper {


    public List<Student> show();


    public Integer update(Student student);


    public Integer deleted(Integer id);


    public Integer insert(Student student);


    public List<Student> selectByname(String name);


    public List<Student> selectByphone(String phone);


}