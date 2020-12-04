package com.hxd.springbootdemo.controller;

import com.hxd.springbootdemo.domain.User;
import com.hxd.springbootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @RequestMapping("retreat")
    public String retreat(Model model) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 30));
        Duration between = Duration.between(now, today);
        model.addAttribute("hours", between.toHours() + "小时");
        model.addAttribute("minutes", between.toMinutes() + "分钟");
        model.addAttribute("seconds", between.toMillis() / 1000 + "秒");
        model.addAttribute("millis", between.toMillis() + "毫秒");
        return "retreat";
    }

}
