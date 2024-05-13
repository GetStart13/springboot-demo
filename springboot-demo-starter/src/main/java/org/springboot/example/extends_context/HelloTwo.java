package org.springboot.example.extends_context;

import org.springframework.stereotype.Component;

@Component("HelloTwo")
public class HelloTwo extends ExtendsRoot {
    @Override
    String talk(String say) {
        return "two" + say;
    }
}
