package com.example.springbootbe.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create or update a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by username
    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user==null){
            throw  new RuntimeException(("User not found with username: " + username));
        }
        return  user;
    }

    // Update a user by username
    public User updateUserByUsername(String username, User updatedUser) {
        if (userRepository.existsByUsername(username)) {
            User currentUser=userRepository.findByUsername(username);

            //update current user
            if (updatedUser.getUsername() != null) currentUser.setUsername(updatedUser.getUsername());
            if (updatedUser.getFirstName() != null) currentUser.setFirstName(updatedUser.getFirstName());
            if (updatedUser.getLastName() != null) currentUser.setLastName(updatedUser.getLastName());
            if (updatedUser.getEmail() != null) currentUser.setEmail(updatedUser.getEmail());
            if (updatedUser.getPassword() != null) currentUser.setPassword(updatedUser.getPassword());
            if (updatedUser.getPhone() != null) currentUser.setPhone(updatedUser.getPhone());
            if (updatedUser.getUserStatus() != null) currentUser.setUserStatus(updatedUser.getUserStatus());

            return userRepository.save(currentUser);
        } else {
            throw new RuntimeException("User not found with username: " + username);
        }
    }

    // Delete a user by username
    @Transactional
    public void deleteUserByUserName(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteUserByUsername(username);
        } else {
            throw new RuntimeException("User not found with username: " + username);
        }
    }

    // Get user by ID
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Update a user (you can implement a method for partial update if needed)
    public User updateUser(Long id, User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
