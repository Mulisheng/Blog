package com.springboot.blog.service;

import com.springboot.blog.po.User;

public interface UserService {
    User checkUser(String username,String password);
    }

