package com.pzz.service;

import com.pzz.dao.StudentDao;
import com.pzz.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentService {
//   @Test
//    public void testFindAll(){
//       StudentDaoImpl studentDao = new StudentDaoImpl();
//       List<Student> students = studentDao.selectAll();
//       for (Student stu:students
//            ) {
//           System.out.println(stu);
//       }
//   }
    @Test
    public void test1(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            //查询指定id
            Student select = mapper.select(2);
            System.out.println(select);
            //查询所有数据
            List<Student> students = mapper.selectAll();
            System.out.println(students);
sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //使用注解测试
    public void test2(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            //查询所有数据
            Student student = mapper.findIfTestParme(3,"tom888","deaf");
            System.out.println(student);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //使用自定义类型转换器测试
    public void test4(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            //插入一条数据
            Student student = new Student();
            student.setName("zhangSan");
            student.setBirthday(new Date());
            mapper.insertTypeHeader(student);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }
    @Test
    //使用foreach测试
    public void test3(){
        try {
            //模拟数据
            List<Integer> ids=new ArrayList<>();
            ids.add(2);
            ids.add(3);
            ids.add(4);
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            //查询所有数据
            List<Student> students = mapper.selectForeach(ids);
            System.out.println(students);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //动态sql测试if语句
    public void testIfSql(){
        try {
            //模拟数据
            Student stu=new Student();
            stu.setId(2);
           // stu.setGender("男");
            //stu.setAge(34);
            //数据连接操作
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            //查询数据
            List<Student> students = mapper.findIfTest(stu);
            System.out.println(students);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
