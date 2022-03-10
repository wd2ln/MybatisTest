package com.pzz.test;

import com.github.pagehelper.PageHelper;
import com.pzz.entity.Dog;
import com.pzz.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MybatisTest {
    @Test
    //修改操作
    public void testUpdate() throws IOException {
        //模拟数据
        Student student=new Student();
        student.setName("王XX");
        student.setId(2);
        //获取配置文件流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int aff = sqlSession.update("com.pzz.dao.StudentMapper.update", student);
        if (aff >0) {//成功提交
            sqlSession.commit();
        }else {//失败回滚
            sqlSession.rollback();
        }
        //释放资源
        sqlSession.close();
    }
    @Test
    //删除操作
    public void testDelete() throws IOException {
        //获取配置文件流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int aff = sqlSession.delete("com.pzz.dao.StudentMapper.del", 1);
        if (aff >0) {//成功提交
            sqlSession.commit();
        }else {//失败回滚
            sqlSession.rollback();
        }
        //释放资源
        sqlSession.close();
    }
    @Test
    //插入操作
    public void testInsert() throws IOException {
        //模拟业务
        Student student=new Student();
        try {
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2000-09-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setAge(78);
        student.setGender("女");
        student.setInfo("deaf");
        student.setName("张强");
        //数据库操作
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("com.pzz.dao.StudentMapper.ins",student);
        if (insert>0) {//成功提交
            sqlSession.commit();
        }else {//失败回滚
            sqlSession.rollback();
        }
        //释放资源
        sqlSession.close();

    }
    @Test
    //查询多个数据
    public void testMybatisTest(){
            try {
                //读取配置文件中的内容到流中
                InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                //获取MyBatis核心类对象sqlSessionFactory
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                //通过会话工厂获取连接
                SqlSession sqlSession = sqlSessionFactory.openSession();
                // 查询指定页中的多少条数据
                PageHelper.startPage(1,2);
                List<Student> o = sqlSession.selectList("com.pzz.dao.StudentDao.selectAll");

                for (Student stu:o
                     ) {
                    System.out.println(stu);
                }
                //释放资源
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    @Test
    //查询指定id数据
    public void testSelectOne(){
        try {
            //模拟数据
            Student student=new Student();
            student.setId(2);
            //读取配置文件中的内容到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取MyBatis核心类对象sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过会话工厂获取连接
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Student o = sqlSession.selectOne("com.pzz.dao.StudentMapper.select",student);
            System.out.println(o);
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
