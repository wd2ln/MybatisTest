package com.pzz.test;

import com.pzz.dao.UserDao;
import com.pzz.entity.User;
import com.pzz.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CacheTest {
    @Test
    public void test1() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            List<Object> objects = sqlSession.selectList("com.pzz.dao.UserDao.findAllCache");
            for (Object object : objects) {
                System.out.println(object);
            }
            List<Object> objects1 = sqlSession.selectList("com.pzz.dao.UserDao.findAllCache");
            for (Object object : objects) {
                System.out.println(object);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @Test
    public void test2(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            SqlSession sqlSession1 = build.openSession();
            List<Object> objects = sqlSession.selectList("com.pzz.dao.UserDao.findAllCache");
            for (Object object : objects) {
                System.out.println(object);
            }
            sqlSession.close();
            List<Object> objects1 = sqlSession1.selectList("com.pzz.dao.UserDao.findAllCache");
            for (Object object : objects1) {
                System.out.println(object);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
