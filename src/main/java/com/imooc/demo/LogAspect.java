package com.imooc.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.imooc.demo.Action)")
    public  void annotationPountCut(){

    }
    @After("annotationPountCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("注解式拦截"+action.name());
    }

    @Before("execution(* com.imooc.demo.DemoMethodService.*(..)))")
    public  void before(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法规则式拦截"+method.getName());



    }
}
