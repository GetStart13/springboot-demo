package com.springboot.multi_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MultiBean {
    private ApplicationContext context;

    private Collection<People> peoples;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void init() {
        Map<String, People> beansOfType = context.getBeansOfType(People.class);
        peoples = beansOfType.values().stream()
                .sorted((v1, v2) -> v2.order() - v1.order()).toList();
        execute();
    }

    public void execute() {
        AtomicInteger index = new AtomicInteger();
        peoples.forEach(v -> v.say("index " + index.getAndIncrement()));
    }
}
