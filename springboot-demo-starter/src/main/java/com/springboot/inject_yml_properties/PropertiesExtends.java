package com.springboot.inject_yml_properties;


import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * <p> 2023/4/23 </p>
 * 继承父类，获取父类注入的 properties，如果这样做，将导致属性被注入两次，应避免这样做，把需要注入的属性放在一个类中
 *
 * @author Fqq
 */
//@Configuration
public class PropertiesExtends extends InjectProperties {
    private String extendsProperties;

    public String getExtendsProperties() {
        return extendsProperties;
    }

    public void setExtendsProperties(String extendsProperties) {
        this.extendsProperties = extendsProperties;
    }

    @PostConstruct
    void init() {
        System.out.println("通过继承 @ConfigurationProperties 父类配置注入: " + extendsProperties);
    }
}
