package com.springboot.springboot_primary.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 如果我们需要取 N 个配置项，通过 @Value 的方式去配置项需要一个一个去取数据，这就显得有点 low 了。
 * 我们可以使用 @ConfigurationProperties。标有 @ConfigurationProperties 的类的所有属性和配置文件中相关
 * 的配置项进行绑定。（默认从全局配置文件中获取配置值），绑定之后我们就可以通过这个类去访问全局配置文件中的属性值了。
 */
@Component
@ConfigurationProperties(prefix = "person2") // 配置前缀，用于在配置文件中寻找对应的数据配置
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
