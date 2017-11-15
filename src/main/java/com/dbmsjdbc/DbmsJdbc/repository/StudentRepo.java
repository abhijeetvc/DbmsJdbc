package com.dbmsjdbc.DbmsJdbc.repository;

import com.dbmsjdbc.DbmsJdbc.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 13/11/17.
 */
public interface StudentRepo {

    List<Student> getStudents();

    Student getSingleStudent(Integer id);

    String saveData(Student student);

    List<Map<String,Object>> getData();

    void saveAllData(Student stu);

}
