package com.example.elearningsystem.service.Impl;

import com.example.elearningsystem.model.User;
import com.example.elearningsystem.repository.UserRepository;
import com.example.elearningsystem.service.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public void editProfile(User user){
        userRepository.save(user);
    }

//    @Override
//    public User getCategoriesOfAUser(String username) {
//        return userRepository.getCategoryOfAUser(username);
//    }
}
