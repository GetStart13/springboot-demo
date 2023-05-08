package com.springboot.extends_context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ExtendsContextDemo {
    @Autowired
    @Qualifier("HelloOne")
    private RootInterface rootInterface1;
    @Autowired
    @Qualifier("HelloTwo")
    private RootInterface rootInterface2;

    @PostConstruct
    public void init() {
        String hello1 = rootInterface1.hello("你好呀，1");
        System.out.println(hello1);
        String hello2 = rootInterface2.hello("你好呀，2");
        System.out.println(hello2);
    }
}
