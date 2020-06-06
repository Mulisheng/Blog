package com.springboot.blog.dao;

import com.springboot.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface TypeRepository extends JpaRepository <Type,Long>{
    Type findByName(String name);
}
