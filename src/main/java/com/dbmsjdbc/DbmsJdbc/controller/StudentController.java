package com.dbmsjdbc.DbmsJdbc.controller;

import com.dbmsjdbc.DbmsJdbc.impl.StudentImpl;
import com.dbmsjdbc.DbmsJdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 13/11/17.
 */

@RestController
public class StudentController {

    @Autowired
    StudentImpl studentImpl;

    @GetMapping(value="/getdata")
    public List<Student> getStudentData(){

        return studentImpl.getStudents();
    }

    @GetMapping(value="/getstu/{id}")
    public Student getStudentData1(@PathVariable Integer id){

        return studentImpl.getSingleStudent(id);
    }

    @PostMapping(value="/savestudent")
    public String saveDataStu(@RequestBody Student student){

        return studentImpl.saveData(student);
    }

    @GetMapping(value="/getall")
    public List<Map<String,Object>> returnAllData(){

        List<Map<String,Object>> list=studentImpl.getData();
        return list;

    }

//    @PostMapping(value="/saveAll")
//    public String saveAll(@RequestBody Student stu){
//
//
//
//    }

}
