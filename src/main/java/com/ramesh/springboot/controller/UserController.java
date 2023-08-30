package com.ramesh.springboot.controller;

import com.ramesh.springboot.entity.User;
import com.ramesh.springboot.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name="CRUD REST API for User ",
        description = "This is CRUD Base application"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    @Operation(
            summary = "Create user rest api",
            description = "Create user rest api for save the user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser=userService.createuser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get a single user rest api",
            description = "Get a single user rest api from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @GetMapping("/user/{id}")
    public ResponseEntity<User>getUserbyId(@PathVariable int id)
    {
        User user=userService.getUserbyId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @Operation(
            summary = "Get All user rest api",
            description = "Get All user rest api from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user=userService.getAllUser();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @Operation(
            summary = "Update user rest api",
            description = "Update user rest api from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id ,@RequestBody User user){
        user.setId(id);
       User updateUser= userService.updateUser(user);
       return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @Operation(
            summary = "DELETE user rest api",
            description = "DELETE user rest api from the  database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @DeleteMapping("deleted/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted successfully",HttpStatus.OK);
    }
}
