package com.example.demo.web.controller;

import com.example.demo.web.dal.mapper.UserMapper;
import com.example.demo.web.dal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by wangwei on 2016/9/2.
 */
@RestController
@RequestMapping({"/home"})
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String user(){
        User user = userMapper.findUserByName("tom");
        return user.getName()+"-----"+user.getAge();
    }
}
