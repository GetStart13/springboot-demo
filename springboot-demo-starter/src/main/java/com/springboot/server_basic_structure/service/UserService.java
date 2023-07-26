package com.springboot.server_basic_structure.service;

import com.springboot.server_basic_structure.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();
}
