package com.imooc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo")
public class HelloController {


    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${test}")
    private String test;
    @Value("${content}")
    private String content;
    @Autowired
    GirlProperties girlProperties;
//不加上默认请求方式，则都可以访问，否则只能get或者post方式才能访问
    @RequestMapping(value = {"/hello","/test"}, method = RequestMethod.POST)
    public String say() {

        return "Hello SpringBoot" + cupSize + age + test + content;
    }

    @RequestMapping(value = "/girl/{id}", method = RequestMethod.GET)
    public String says(@PathVariable("id") int id) {
        return "路劲传参返回结果为--" + id+"---"+girlProperties.getCupSize()
                + girlProperties.getAge();

    }
    //@RequestMapping(value = "/girl1", method = RequestMethod.GET)
    @GetMapping(value = "/girl1")
    public String says1(@RequestParam("id") String id) {
        return "普通传参返回结果为--" + id+"---";

    }
    @RequestMapping(value = "/girl2", method = RequestMethod.GET)
    //required=false,表示参数不是必传，给默认值
    public String says2(@RequestParam(value = "id",required = false,defaultValue = "0") String id) {
        return "普通2传参返回结果为--" + id+"---";

    }
}
