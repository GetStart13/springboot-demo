package com.springboot.thread_wait;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/thread")
public class TreadWait {
    private String field;

    /**
     * 成员变量赋值后唤醒线程
     */
    @GetMapping("/notify")
    @ResponseBody
    public String notifyMyself(@RequestParam String name) {
        this.field = name;
        synchronized (this) {
            notifyAll();
        }
        return this.toString();
    }

    /**
     * 等待成员变量被赋值
     */
    @GetMapping("/wait")
    @ResponseBody
    public String waitMyself() {
        synchronized (this) {
            while (this.field == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return this.field;
    }
}
