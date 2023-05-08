package com.springboot.springboot_primary;

import com.springboot.springboot_primary.service.ServiceTest;
import com.springboot.springboot_primary.domain.User;
import com.springboot.springboot_primary.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;


@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * springboot整合redis，在配置文件配置连接的redis的配置信息
     */
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testSet(){
        redisTemplate.boundValueOps("name").set("zhangsan");
    }
    @Test
    public void testGet(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    /**
     * springboot整合mybatis，在配置文件配置mybatis的连接信息
     */
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        List<User> userList2 = userMapper.findAll2();
        System.out.println(userList);
        System.out.println(userList2);
    }
    @Autowired
    private ServiceTest serviceTest;

}
