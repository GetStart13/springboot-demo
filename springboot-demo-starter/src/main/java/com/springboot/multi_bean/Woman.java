package com.springboot.multi_bean;

import org.springframework.stereotype.Component;

@Component
public class Woman extends PeopleAbstract {
    @Override
    public void sayNotChange(String msg) {
        System.out.println("woman: " + msg);
    }

    @Override
    public int order() {
        return 0;
    }
}
