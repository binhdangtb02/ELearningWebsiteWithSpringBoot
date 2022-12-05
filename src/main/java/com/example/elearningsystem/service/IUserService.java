package com.example.elearningsystem.service;

import com.example.elearningsystem.model.User;

public interface IUserService {
    public User findByUsername(String username);
    public void editProfile(User user);
}
