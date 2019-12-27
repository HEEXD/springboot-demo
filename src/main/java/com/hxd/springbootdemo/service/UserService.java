package com.hxd.springbootdemo.service;

import com.hxd.springbootdemo.domain.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<User> queryAll();

    List<User> queryUserByPage(Integer page, Integer rows);

    void addUser(User user);

    void updateUserById(User user);

    void deleteById(Long id);
}
