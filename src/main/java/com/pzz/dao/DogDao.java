package com.pzz.dao;

import com.pzz.entity.Dog;

import java.util.List;

public interface DogDao {
//    orm映射问题
    public List<Dog> selectAll1();
    List<Dog> selectAllMap();
    List<Dog> selectAll_xhx();
}
