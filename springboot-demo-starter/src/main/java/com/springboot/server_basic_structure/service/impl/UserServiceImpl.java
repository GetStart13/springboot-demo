package com.springboot.server_basic_structure.service.impl;

import com.springboot.server_basic_structure.domain.User;
import com.springboot.server_basic_structure.mapper.UserMapper;
import com.springboot.server_basic_structure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service 业务层
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<User> list() {
        List<User> all = mapper.findAll();
        System.out.println("user list: " + all);
        return all;
    }
}
