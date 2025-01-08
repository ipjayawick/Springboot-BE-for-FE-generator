package com.example.springbootbe.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public  UserController(UserService userService){this.userService=userService;}

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get user by username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    // Update a user by username
    @PutMapping("/{username}")
    public ResponseEntity<User> updateUserByUsername(@PathVariable String username, @RequestBody User user) {
        User updatedUser = userService.updateUserByUsername(username,user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user by username
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUserName(username);
        return ResponseEntity.ok().build();
    }

//    // Get user by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//
//    // Update a user by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        User updatedUser = userService.updateUser(id, user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    // Delete a user by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }
}
