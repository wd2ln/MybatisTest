package com.pzz.dao;

import com.pzz.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public List<Student>  selectAll();
    public Student select(int id);
    public List<Student> findIfTest(Student student);
    public Student findIfTestParme(@Param("id") int id,@Param("name") String name, @Param("info") String info);
    public List<Student> selectForeach(List<Integer> id);
    public void insertTypeHeader(Student student);
}
