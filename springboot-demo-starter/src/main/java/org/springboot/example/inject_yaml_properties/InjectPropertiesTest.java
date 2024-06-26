package org.springboot.example.inject_yaml_properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InjectPropertiesTest {
    @Value("${singleQuoteNoConvert}")
    private String singleQuoteNoConvert;
    @Value("${doubleQuoteHaveConvert}")
    private String doubleQuoteHaveConvert;
    private InjectProperties injectProperties;

    @Autowired
    public void setInjectProperties(InjectProperties injectProperties) {
        this.injectProperties = injectProperties;
    }

    @PostConstruct
    void test() {
        System.out.println("单引号纯量字符无转义: " + singleQuoteNoConvert);
        System.out.println("双引号纯量字符有转义: " + doubleQuoteHaveConvert);
        System.out.println("在 @ConfigurationProperties 中通过 @Value 注入值(不建议，通过该方式会导致查找值的注入位置困难和混乱): "
                + injectProperties.getName());
        System.out.println("通过 @ConfigurationProperties 注入数组: " + Arrays.toString(injectProperties.getArray()));
        System.out.println("通过 @ConfigurationProperties 注入对象: " + injectProperties.getUser());
        System.out.println("通过 @ConfigurationProperties 注入 List 集合: " + injectProperties.getList());
        System.out.println("将属性以对象形式注入: " + injectProperties.getHierarchical());
    }

}
