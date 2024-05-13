package springboot.example.server_basic_structure;

import org.springboot.example.server_basic_structure.domain.User;
import org.springboot.example.server_basic_structure.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;


@SpringBootTest
class SpringbootDemoApplicationTests {
    /**
     * springboot 整合 mybatis，在配置文件配置 mybatis 的连接信息
     */
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    /**
     * springboot 整合 redis，在配置文件配置连接的 redis 的配置信息
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    void testSet() {
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    void testGet() {
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    void testFindAll() {
        List<User> userList2 = userMapper.findAll();
        System.out.println("mybatis 注解方式执行 SQL: " + userList2);
        assertNotNull(userList2);
    }
}
