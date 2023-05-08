package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//(scanBasePackages = "com.mywork")// 如果与启动类不同包，要扫描注解就要配置主包
@MapperScan("com.springboot.springboot_primary.mapper")
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            if (beanDefinitionName.endsWith("Controller")) {
                System.out.println("------------ controller ---------------  " + beanDefinitionName);
            } else if (beanDefinitionName.endsWith("ConflictOne")) {
                System.out.println("------------ conflict bean ---------------  " + beanDefinitionName);
            }
        }
    }

}
