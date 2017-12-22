package com.river;


import com.river.pojo.User;
import com.river.service.UserService;
import com.river.service.jyservice.JYService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Administrator on 2017/9/26.
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.river.mapper")
public class SMApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private JYService jyService;

    public static void main(String[] args) {
        SpringApplication.run(SMApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        /*User user = new User();
        user.setName("name1");
        user.setSex("nan");
        user.setAge(11);
        userService.insert(user);
        System.out.println("users--->"+userService.selectUsers());*/
        jyService.test();

    }
}


