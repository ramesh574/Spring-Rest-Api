package com.ramesh.springboot.services;

import com.ramesh.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createuser(User user);
    User getUserbyId(int id);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(int id);
}
