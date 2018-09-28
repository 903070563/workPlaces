package com.imooc.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.imooc.demo")//扫描要拦截的包
//@EnableAspectJAutoProxy //
public class AopConfig {
}
