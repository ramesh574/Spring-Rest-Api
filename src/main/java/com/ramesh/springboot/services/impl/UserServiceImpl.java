package com.ramesh.springboot.services.impl;

import com.ramesh.springboot.entity.User;
import com.ramesh.springboot.repo.UserRepository;
import com.ramesh.springboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
private UserRepository userRepository;
    @Override
    public User createuser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserbyId(int id) {
         Optional<User> optionalUser =userRepository.findById(id);
         return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
      User updatedUser=  userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
