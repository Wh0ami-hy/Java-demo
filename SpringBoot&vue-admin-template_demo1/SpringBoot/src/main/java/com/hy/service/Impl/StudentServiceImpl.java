package com.hy.service.Impl;

import com.hy.entity.Student;
import com.hy.mapper.StudentMapper;
import com.hy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> show() {
        return studentMapper.show();
    }

    @Override
    public Integer update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Integer deleted(Integer id) {
        return studentMapper.deleted(id);
    }

    @Override
    public Integer insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> selectByname(String name) {
        return studentMapper.selectByname(name);
    }

    @Override
    public List<Student> selectByphone(String phone) {
        return studentMapper.selectByphone(phone);
    }
}
