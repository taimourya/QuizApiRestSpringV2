package com.example.api.dao;

import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User findUserByEmailAndPassword(String username, String password);

    @Query("select u from User u where u.username = ?1")
    User findUserByUsername(String username);
}
