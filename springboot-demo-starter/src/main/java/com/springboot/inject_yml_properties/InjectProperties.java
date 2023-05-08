package com.springboot.inject_yml_properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p> 2023/4/10 </p>
 * 通过 @ConfigurationProperties 要求必须有 setter 方法，子类可以继承该类获取注入属性
 *
 * @author Fqq
 */
@Configuration
@ConfigurationProperties(prefix = "properties")
public class InjectProperties {
    private String name;

    // 默认值 defaultName
    @Value("${name:defaultName}")
    public void setName(String name) {
        this.name = name;
    }

    private String[] array;
    private User user;
    private List<String> list;
    private HierarchicalProperties hierarchical = new HierarchicalProperties();

    public String getName() {
        return name;
    }

    public String[] getArray() {
        return array;
    }

    // 注入数组，setter 方法必须有
    public void setArray(String[] array) {
        this.array = array;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public HierarchicalProperties getHierarchical() {
        return hierarchical;
    }

    /**
     * 注入深层的对象属性，所有的配置属性都是以 key: value 形式存在，因此 Map<String, Object> 可以接收所有类型的 yml 配置属性
     */
    public void setHierarchical(HierarchicalProperties hierarchical) {
        this.hierarchical = hierarchical;
    }


    public InjectProperties() {
    }

    @Autowired // 通过构造方法注入 bean
    public InjectProperties(Environment environment) {
        String nameProperty = environment.getProperty("properties.nameInner", String.class);
        System.out.println("通过 Environment 注入属性: " + nameProperty);
        // Environment 不支持注入 List 集合，但支持逗号分隔的数组
        String[] strings = environment.getProperty("properties.array_separated", String[].class);
        System.out.println("通过 Environment 注入数组: " + Arrays.toString(strings));
    }


    public static class HierarchicalProperties {
        /**
         * 默认值
         */
        private String name = "default name";
        private String value;
        private Map<String, Object> map;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Map<String, Object> getMap() {
            return map;
        }

        public void setMap(Map<String, Object> map) {
            this.map = map;
        }

        @Override
        public String toString() {
            return "HierarchicalProperties{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    ", map=" + map +
                    '}';
        }
    }
}
