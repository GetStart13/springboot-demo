package com.springboot.multi_bean;

import org.springframework.stereotype.Component;

@Component
public class Man extends PeopleAbstract {

    @Override
    public void sayNotChange(String msg) {
        System.out.println("man: " + msg);
    }

    @Override
    public int order() {
        return -1;
    }
}
