package com.springboot.extends_context;

import org.springframework.stereotype.Component;

@Component("HelloOne")
public class HelloOne extends ExtendsRoot {
    @Override
    String talk(String say) {
        return "one" + say;
    }
}
