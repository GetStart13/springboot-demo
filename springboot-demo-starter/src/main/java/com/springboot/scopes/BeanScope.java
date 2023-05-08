package com.springboot.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> 2023/3/14 </p>
 * spring bean 范围
 *
 * @author Fqq
 */
@Controller
@RequestMapping("/bean")
@Scope(scopeName = "prototype")// 原型模式，每次的请求都会实例化一个新的对象，如果其他类注入了该 bean，注入的 bean 不会改变，始终是注入时的 bean
public class BeanScope {
    private String field;
    @Autowired
    private ApplicationContext context;

    @GetMapping("/scope")
    @ResponseBody
    public String change(@RequestParam String name) {
        Object bean = context.getBean("beanScope");
        System.out.println(bean);
        this.field = name;
        // 唤醒该对象上的所有的锁
        synchronized (this) {
            notifyAll();
        }
        return this.toString();
    }

    @GetMapping("/look")
    @ResponseBody
    public String getField() {
        Object bean = context.getBean("beanScope");
        // 上下文中，每次 bean 的实例地址都不一样
        System.out.println(bean);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            if (name.endsWith("beanScope")) {
                System.out.println(name);
            }
        }
        return this.field;
    }

    @GetMapping("/lock")
    @ResponseBody
    public String lock() {
        // 多例情况下，锁住的是对象，所以在上边唤醒对象的所有线程也无法释放该锁，因为不同实例不同对象
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
