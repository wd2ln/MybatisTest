package com.pzz.dao;

import com.pzz.entity.Department;
import com.pzz.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    //一对一映射
    List<Employee> findAll();
    //一对多映射
    List<Department> findAll1(Integer id);
}
