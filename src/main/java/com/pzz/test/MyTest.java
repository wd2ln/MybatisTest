package com.pzz.test;

import com.pzz.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void testMy(){
        //定义xml配置文件路径
        String resource="mybatis-config.xml";
        SqlSession sqlSession=null;
        try {
            //获取xml配置流
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            //获取sqlSession工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //通过工厂连接会话
             sqlSession = sqlSessionFactory.openSession();
//            获取数据
            List<Student> list = sqlSession.selectList("com.pzz.dao.StudentMapper.selectAll");
            for (Student stu:list
                 ) {
                System.out.println(stu);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            sqlSession.close();
            sqlSession.clearCache();
        }
    }

}
