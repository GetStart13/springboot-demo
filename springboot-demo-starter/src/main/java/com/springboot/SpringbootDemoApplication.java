package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p> 2023/7/26 </p>
 * springboot 启动类
 *
 * @author Fqq
 */
@SpringBootApplication//(scanBasePackages = "com.mywork")// 配置 springboot 包扫描，默认扫描启动类所在的包及其子包
@MapperScan("com.springboot.server_basic_structure.mapper")
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}
