package com.pzz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String name;
    //一对多 一个部门有多个员工
    private List<Employee> employees;
}
