package com.demo.web.controller;

import com.demo.web.dal.mapperOne.UserMapperOne;
import com.demo.web.dal.mapperTwo.UserMapperTwo;
import com.demo.web.dal.mapperThree.UserMapperThree;
import com.demo.web.dal.model.User;
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
    UserMapperOne userMapperOne;

    @Autowired
    UserMapperTwo userMapperTwo;

    @Autowired
    UserMapperThree userMapperThree;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String user(){
        User user1 = userMapperOne.getOne(1L);
        User user2 = userMapperTwo.getOne(1L);
        User user3 = userMapperThree.getOne(1L);
        System.out.println("user1:"+user1.getName()+user1.getAge());
        System.out.println("user2:"+user2.getName()+user2.getAge());
        System.out.println("user3:"+user3.getName()+user3.getAge());
        return "success";
    }

}
