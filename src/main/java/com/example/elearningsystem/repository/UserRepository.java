package com.example.elearningsystem.repository;

import com.example.elearningsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);


//    public User getCategoryOfAUser(String username);
}
