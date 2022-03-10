package com.pzz.test;

import com.pzz.dao.EmployeeDao;
import com.pzz.entity.Department;
import com.pzz.entity.Employee;
import com.pzz.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MoreTableTest {
    @Test
    //一对一测试
    public void test1(){
        EmployeeDao mapper = MyBatisUtils.getMapper(EmployeeDao.class);
        List<Employee> employees = mapper.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        MyBatisUtils.commit();
    }
    @Test
    //一对多测试
    public void test2(){
        EmployeeDao mapper = MyBatisUtils.getMapper(EmployeeDao.class);
        List<Department> departments = mapper.findAll1(1);
        for (Department department : departments) {
            System.out.println(department);
        }
        MyBatisUtils.commit();
    }
}
