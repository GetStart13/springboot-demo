package org.springboot.example.server_basic_structure.service;

import org.springboot.example.server_basic_structure.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();
}
