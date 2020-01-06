package com.hxd.springbootdemo.controller;

import com.hxd.springbootdemo.domain.User;
import com.hxd.springbootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("findById")
    @ResponseBody
    public User findById(@RequestParam int id) {
        return userService.findById(id);
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public List<User> queryAll() {
        return userService.queryAll();
    }

    // 分页查询 page:页码 rows:每页数量
    @RequestMapping("queryUserByPage")
    @ResponseBody
    public List<User> queryUserByPage(@RequestParam Integer page, @RequestParam Integer rows) {
        return userService.queryUserByPage(page, rows);
    }

    // 测试freemarker
    @RequestMapping("freeMarkerDemo")
    public String freeMarkerDemo(Model model) {
        List<User> list = userService.queryAll();
        model.addAttribute("list", list);
        return "freemarker";
    }

    // 测试thymeleaf
    @RequestMapping("thymeleafDemo")
    public String thymeleafDemo(Model model) {
        List<User> list = userService.queryAll();
        model.addAttribute("list", list);
        return "thymeleaf";
    }

}