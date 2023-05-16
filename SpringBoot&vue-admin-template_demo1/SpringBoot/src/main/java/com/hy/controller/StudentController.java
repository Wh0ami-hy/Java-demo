package com.hy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hy.entity.Student;
import com.hy.service.StudentService;
import com.hy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/show")
    public Result show() {

        List<Student> students = studentService.show();
        System.out.println(students);
        return Result.ok().data("data",students);
    }
    @PostMapping("/deleted/{id}")
    public Result deleted(@PathVariable Integer id) {

        studentService.deleted(id);
        return Result.ok();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.ok();
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody Student student) {
        studentService.insert(student);
        return Result.ok();
    }
    @PostMapping("/selected")
    public Result select(@RequestBody JSONObject param){
        String content = param.getString("content");
        String select = param.getString("select");
        List<Student> students = null;
        System.out.println(select + "-->" + content);

        if (select.equals("phone")) {
            students = studentService.selectByphone(content);
        }else if (select.equals("name")){
            students = studentService.selectByname(content);
        }
        return Result.ok().data("data",students);
    }
}

