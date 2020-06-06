package com.springboot.blog.controller;

import com.springboot.blog.NotFoundException;
import com.springboot.blog.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Controller

public class HelloController {
    @RequestMapping("/hello")
    public String index(/*@PathVariable Integer id, @PathVariable String name*/)
    {
        System.out.println("进入hello");
//        System.out.println(id);
//        System.out.println(name);
        return "/index";
    }

    @RequestMapping("/blog")
    public String blog(/*@PathVariable Integer id, @PathVariable String name*/)
    {
        System.out.println("进入hello");
//        System.out.println(id);
//        System.out.println(name);

     
        return "blog";
    }
}
