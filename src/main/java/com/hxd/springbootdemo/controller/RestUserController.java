package com.hxd.springbootdemo.controller;

import com.hxd.springbootdemo.commons.entity.CommonResult;
import com.hxd.springbootdemo.commons.entity.MapResultHandler;
import com.hxd.springbootdemo.domain.User;
import com.hxd.springbootdemo.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hexudong
 * @Description:restful风格api
 */
@RestController
@RequestMapping(value = "users")
public class RestUserController {

    @Resource
    private UserService userService;

    @Resource
    SqlSessionFactory sqlSessionFactory;

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

    @PostMapping("login")
    public CommonResult login(@RequestBody User user) {
        List<User> list = userService.getByNameAndPwd(user);
        if (list.size() == 0) {
            return new CommonResult(HttpStatus.OK.value(), "账号或密码错误").withDetails("flag", "failure");
        }
        return new CommonResult(HttpStatus.OK.value(), "登录成功").withDetails("flag", "success");
    }

    /**
     * 测试 MyBatis 返回 Map，查询字段两列分别作为 key 和 value
     */
    @GetMapping("getMap")
    public CommonResult getMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MapResultHandler handler = new MapResultHandler();
        sqlSession.select("com.hxd.springbootdemo.dao.UserDao.getMap", handler);
        Map<String, String> map = handler.getMappedResults();
        sqlSession.close();
        return new CommonResult(HttpStatus.OK.value(), "").withDetails("data", map);
    }

}
