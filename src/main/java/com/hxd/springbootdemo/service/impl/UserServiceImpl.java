package com.hxd.springbootdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hxd.springbootdemo.dao.UserDao;
import com.hxd.springbootdemo.domain.User;
import com.hxd.springbootdemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public List<User> queryUserByPage(Integer page, Integer rows) {
        // 设置分页
        PageHelper.startPage(page,rows);
        // 使用通用Mapper的方法进行查询所有数据
        List<User> userList = userDao.queryAll();
        return userList;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }


}
