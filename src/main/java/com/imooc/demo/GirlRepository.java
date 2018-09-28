package com.imooc.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //按照年龄来查询
    public List<Girl> findByAge(Integer age);
}
