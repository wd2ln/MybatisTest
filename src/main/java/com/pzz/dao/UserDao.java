package com.pzz.dao;

import com.pzz.entity.User;

import java.util.List;

public interface UserDao{
    List<User> findAllCache ();
}
