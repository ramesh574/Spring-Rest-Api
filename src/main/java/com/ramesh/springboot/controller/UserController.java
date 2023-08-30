package com.ramesh.springboot.controller;

import com.ramesh.springboot.entity.User;
import com.ramesh.springboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser=userService.createuser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User>getUserbyId(@PathVariable int id)
    {
        User user=userService.getUserbyId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user=userService.getAllUser();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id ,@RequestBody User user){
        user.setId(id);
       User updateUser= userService.updateUser(user);
       return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @DeleteMapping("deleted/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted successfully",HttpStatus.OK);
    }
}
