package com.pzz.dao;

import com.pzz.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查询所有学生
    public List<Student>  selectAll();
    public Student select(int id);
    public List<Student> findIfTest(Student student);
    public Student findIfTestParme(@Param("id") int id,@Param("name") String name, @Param("info") String info);
    public List<Student> selectForeach(List<Integer> id);
    public void insertTypeHeader(Student student);
    //主键回填测试
    public void keyRollWriter(Student student);
    //orm映射问题
    public List<Student> ormErrorTest(Integer id);
    //动态sql-----foreach测试---常用于批量删除
    Integer testForeach(Integer...args);

}
