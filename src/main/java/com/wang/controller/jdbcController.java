//package com.wang.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class jdbcController {
//
//    //XXXX Template : SpringBoot已经配置好的模板bean, 拿来即用, 封装好了CRUD
//    //jdbc
//    //redis
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    //查询数据库的所有信息
//    //没有实体类, 数据库中的东西怎样获取? ==> Map
//    @GetMapping("/userList")
//    public List<Map<String, Object>> userList() {
//        String sql = "select * from user";
//        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
//        return list_maps;
//    }
//
//    @GetMapping("/addUser")
//    public String addUser() {
//        String sql = "insert into mybatis.user(id, name, pwd) values(5, '小明', '123456')";
//        int update = jdbcTemplate.update(sql);
//        if (update == 1) {
//            return "addUser-OK";
//        } else {
//            return "addUser-Fail";
//        }
//    }
//
//    //拼接SQL, 用RestFul风格传参, 要用@PathVariable注解
//    @GetMapping("/updateUser/{id}")
//    public String updateUser(@PathVariable("id") int id) {
//        String sql = "update mybatis.user set name = ?, pwd = ? where id=" + id;
//
//        //封装
//        Object[] objects = new Object[2];
//        objects[0] = "小明2";
//        objects[1] = "1233211234567";
//
//        //jdbcTemplate中的update重载了prepareStatement, 直接传需要的对象即可
//        int update = jdbcTemplate.update(sql, objects);
//        if (update == 1) {
//            return "updateUser-OK";
//        } else {
//            return "updateUser-Fail";
//        }
//    }
//
//    @GetMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        String sql = "delete from mybatis.user where id = ?";
//
//        //jdbcTemplate中的update重载了prepareStatement, 直接传需要的对象即可
//        //int也是object, 直接传入即可
//        int update = jdbcTemplate.update(sql, id);
//        if (update == 1) {
//            return "deleteUser-OK";
//        } else {
//            return "deleteUser-Fail";
//        }
//    }
//
//}
