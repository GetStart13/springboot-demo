package org.springboot.example.extends_context;

import org.springframework.stereotype.Component;

@Component
public class MiddleBean {
    public void note() {
        System.out.println("中间注入的 bean，测试环境上下文");
    }
}
