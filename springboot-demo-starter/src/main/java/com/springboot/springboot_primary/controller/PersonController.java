package com.springboot.springboot_primary.controller;


import com.springboot.springboot_primary.domain.Person;
import com.springboot.springboot_primary.domain.SpecialGetSet;
import com.springboot.springboot_primary.domain.User;
import com.springboot.springboot_primary.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springboot")
public class PersonController {

    /**
     * 用 @Value 方式获取数据
     */
    @Value("${name}")
    private String name;
    @Value("${person1.name}")
    private String name2;
    @Value("${address1[0]}")
    private String addr;
    /**
     * Environment 对象方式获取数据
     */
    @Autowired
    private Environment environment;
    @Autowired
    private Person person;
    @Autowired
    private UserMapper mapper;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show() {
        System.out.println(name); // value 方式获取数据
        System.out.println(name2); // value ...
        System.out.println(addr);  //value ...
        System.out.println("------------------");

        System.out.println(environment.getProperty("person1.name")); // Environment 方式

        System.out.println("------------------");

        System.out.println(person); // @ConfigurationProperties 绑定配置文件的方式获取数据

        System.out.println("------------------");
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        return "hello springboot!";
    }

    @PostMapping("/get_set")
    public String testSpecialGetSet(@RequestBody SpecialGetSet getSet) {
        System.out.println(getSet);
        return "success";
    }

    @GetMapping("/test/response")
    public ResponseEntity<Object> testResponseEntity() {
        ResponseEntity<Object> response = ResponseEntity.ok("测试 http 的实体");
        System.out.println(response);
        return response;
    }

    @GetMapping("/http/get")
    public ResponseEntity<String> testHttpGet(@RequestParam("param") String param) {
        System.out.println(param);
        return ResponseEntity.ok("---------> revive http get request --------->");
    }

    @PostMapping("/http/post")
    public ResponseEntity<String> testHttpPost(@RequestBody List<Object> body) {
        System.out.println(body);
        return ResponseEntity.ok("---------> receive http post request --------->");
    }

    /**
     * GET 请求可以自动封装实体
     */
    @GetMapping("/get/entity")
    public ResponseEntity<String> getMethodEntity(@RequestParam("id") String ids, User user) {
        System.out.println(user);
        System.out.println(ids);
        return ResponseEntity.ok("success");
    }
}
