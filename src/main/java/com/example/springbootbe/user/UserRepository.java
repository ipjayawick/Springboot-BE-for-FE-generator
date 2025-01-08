package com.example.springbootbe.user;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    void deleteUserByUsername(String username);

}
