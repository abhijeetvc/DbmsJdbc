package com.dbmsjdbc.DbmsJdbc.impl;

import com.dbmsjdbc.DbmsJdbc.model.Student;
import com.dbmsjdbc.DbmsJdbc.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 13/11/17.
 */

@Repository
public class StudentImpl implements StudentRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudents() {

        String sql="select * from student";

        List<Student> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));

        return list;
    }

    @Override
    public Student getSingleStudent(Integer id) {

        String sql="select * from student where id=?";

        Student st=jdbcTemplate.
                queryForObject(sql,
                new Object[]{id},new int[]{Types.INTEGER},new BeanPropertyRowMapper<>(Student.class));

        return st;
    }

    @Override
    public String saveData(Student student) {

        String sql="insert into student values(?,?,?)";

        jdbcTemplate.update(sql,new Object[]{student.getId(),
        student.getName(),student.getCity()},new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR});

        return "Data saved";
    }

    @Override
    public List<Map<String, Object>> getData() {

        String sql="select s.id,s.name,s.city,d.deptname from " +
                "student s,dept d where s.deptid=d.id";

        List<Map<String,Object>> list=jdbcTemplate
                .queryForList(sql);

        return list;
    }

    @Override
    public void saveAllData(Student stu) {



    }
}
