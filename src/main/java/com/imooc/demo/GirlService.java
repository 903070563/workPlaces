package com.imooc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl a=new Girl();
        a.setAge(18);
        a.setCupSize("H");
        girlRepository.save(a);
        Girl b=new Girl();
        b.setAge(19);
        b.setCupSize("HGGG");
        girlRepository.save(b);


    }
}
