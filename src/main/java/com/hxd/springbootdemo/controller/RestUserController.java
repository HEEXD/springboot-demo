package com.hxd.springbootdemo.controller;

import com.hxd.springbootdemo.domain.User;
import com.hxd.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hexudong
 * @Description:测试restful风格api
 */
@RestController
@RequestMapping(value = "users")
public class RestUserController {

    @Resource
    private UserService userService;

    private static Map<String, Object> msg = new HashMap<>();

    // 根据id查询用户,url中的id可通过@PathVariable绑定到函数的参数中
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    // 新增用户
    @PostMapping(value = "/")
    public Map<String, Object> addUser(@ModelAttribute User user) {
        userService.addUser(user);
        msg.put("提示信息", "新增成功");
        return msg;
    }

    // 根据id更新用户信息
    @PutMapping(value = "/")
    public Map<String, Object> updateUserById(@ModelAttribute User user) {
        userService.updateUserById(user);
        msg.put("提示信息", "修改成功");
        return msg;
    }

    // 根据id删除用户
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        msg.put("提示信息", "删除成功");
        return msg;
    }

}
