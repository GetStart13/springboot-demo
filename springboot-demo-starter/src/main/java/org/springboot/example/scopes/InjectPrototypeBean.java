package org.springboot.example.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注入原型 bean
 */
@Controller
@CrossOrigin("*")
public class InjectPrototypeBean {
    @Autowired
    private BeanScope beanScope;
    private String name;
    private final ThreadLocal<String> flag = new ThreadLocal<>();

    @GetMapping("/check")
    @ResponseBody
    public String check() {
        return beanScope.getField();
    }

    @GetMapping("/concurrent")
    @ResponseBody
    public String check(@RequestParam String name) {
        try {
            this.name = name;
            // 同时刷新 one.html 和 two.html，发现数据两个页面相互窜数据
//        return this.name;// 多线程中单例模式中，如果单例模式中存在成员变量，该变量其他线程可见，变量的修改会被其它线程读取到，线程不安全
//        return name;// 如果不通过成员变量获取，局部变量对其它线程不可见，线程安全
            this.flag.set(name);
            return this.flag.get();
        } finally {
            unload();
        }
    }

    public void unload() {
        this.flag.remove();
    }
}
