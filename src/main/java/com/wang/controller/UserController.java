package com.wang.controller;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/userList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/addUser")
    public String addUser() {
        int i = userMapper.addUser(new User(6, "小明", "123456"));
        return i == 1 ? "ok" : "fail";
    }

    @GetMapping("/updateUser")
    public String updateUser() {
        int i = userMapper.updateUser(new User(6, "小明2", "654321"));
        return i == 1 ? "ok" : "fail";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        int i = userMapper.deleteUser(6);
        return i == 1 ? "ok" : "fail";
    }
}
