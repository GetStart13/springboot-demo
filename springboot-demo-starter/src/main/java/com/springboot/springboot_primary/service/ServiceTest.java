package com.springboot.springboot_primary.service;

import com.springboot.springboot_primary.domain.User;
import com.springboot.springboot_primary.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试service类
 */
@Service
public class ServiceTest {
    @Autowired
    private UserMapper mapper;

    public void show() {
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        System.out.println("service is running...");
    }
}
