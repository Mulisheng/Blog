package com.springboot.blog.service;

import com.springboot.blog.dao.UserRepository;
import com.springboot.blog.po.User;
import com.springboot.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
       User user= userRepository.findByUsernameAndPassword(username,password);
       System.out.println(username);
        System.out.println(password);
       return user;
    }
}
