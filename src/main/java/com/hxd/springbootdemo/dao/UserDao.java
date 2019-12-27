package com.hxd.springbootdemo.dao;

import com.hxd.springbootdemo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    // 使用注解
    @Select("select * from user where id = ${value}")
    User findById(int id);

    // 使用xml配置文件
    List<User> queryAll();

    void addUser(User user);

    void updateUserById(User user);

    void deleteById(@Param("id") Long id);
}
