package com.pzz.test;

import com.pzz.dao.EmployeeDao;
import com.pzz.dao.StudentDao;
import com.pzz.entity.Department;
import com.pzz.entity.Student;
import com.pzz.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class AutoSqlTest {
    @Test
    //foreach测试
    public void test1(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Integer aff = mapper.testForeach(7,8,9);
        System.out.println(aff);
        MyBatisUtils.commit();
    }
}
