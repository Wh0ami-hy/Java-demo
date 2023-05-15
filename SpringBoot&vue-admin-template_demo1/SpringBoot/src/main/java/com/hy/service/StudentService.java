package com.hy.service;

import com.hy.entity.Student;
import java.util.List;

public interface StudentService {

    public List<Student> show();


    public Integer update(Student student);


    public Integer deleted(Integer id);


    public Integer insert(Student student);


    public List<Student> selectByname(String name);


    public List<Student> selectByphone(String phone);
}
