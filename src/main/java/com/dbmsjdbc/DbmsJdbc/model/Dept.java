package com.dbmsjdbc.DbmsJdbc.model;

/**
 * Created by abhi on 15/11/17.
 */
public class Dept {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    Integer id;
    String deptName;

}
