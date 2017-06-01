package com.example.demo.web.job;

import com.example.demo.web.dal.mapper.UserMapper;
import com.example.demo.web.dal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanglei on 2017/5/31.
 */
@Component
public class ScheduledTask {

    @Autowired
    UserMapper userMapper;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void getTask1() {
        System.out.println("任务1,从配置文件加载任务信息，当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 2000)
    public void getTask2() {
        User user = userMapper.findUserByName("tom");
        System.out.println("任务2,从配置文件加载任务信息，当前时间：" + dateFormat.format(new Date())+user.getName()+"-----"+user.getAge());
    }

}

