package com.pzz.test;

import com.pzz.dao.DogDao;
import com.pzz.dao.StudentDao;
import com.pzz.entity.Dog;
import com.pzz.entity.Student;
import com.pzz.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class OrgMapperErrorTest {
    //测试查询
    @Test
    public void testOrgMapper(){
        //获取映射
        DogDao mapper = MyBatisUtils.getMapper(DogDao.class);
        //执行查询方法
        List<Dog> dogs = mapper.selectAll1();
        for (Dog dog:dogs
             ) {

            System.out.println(dog);
        }
        MyBatisUtils.commit();
    }
}
