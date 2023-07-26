package com.springboot.server_basic_structure.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.server_basic_structure.domain.SpecialGetSet;
import com.springboot.server_basic_structure.domain.User;
import com.springboot.server_basic_structure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p> 2023/7/26 </p>
 * Controller 控制层 / 访问层
 *
 * @author Fqq
 */
@RestController // 如果使用 @Controller 注解，会返回一个视图
@RequestMapping("/user")
public class UserController {
    /**
     * 不推荐字段属性自动注入 @Autowired，主要原因是非 springboot 框架将无法通过 setter 注入
     */
    private UserService userService;
    private ObjectMapper objectMapper;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * springboot 提供了一个全局的 json 处理对象，可以直接使用此对象，或者配置化 json 映射
     *
     * @param objectMapper json 处理类
     */
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Get 方法，一般用于查询
     * <br>
     * Get 方法中，请求参数自动映射到 User 实体，可以通过实体的传递，以减少接口参数的变更，
     * 但存入数据库时需要注意只存储限定数据，避免脏数据
     *
     * @param user 用户实体，通过此方式传参，可以将维护角度转移到实体中
     * @return 用户列表
     */
    @GetMapping(value = "/list")
    public List<User> list(User user) {
        System.out.println("user: " + user);
        List<User> all = userService.list();
        System.out.println("users: " + all);
        return all;
    }

    /**
     * Put 方法，一般用于新增
     * <br>
     * 通过 @RequestBody 映射请求体到实体
     *
     * @param getSet 实体，实体的映射通过 getter / setter 访问器，映射工具使用 jackson
     * @return 结果
     */
    @PutMapping("/create")
    public String testSpecialGetSet(@RequestBody SpecialGetSet getSet) {
        System.out.println(getSet);
        return "Create success";
    }

    /**
     * Post 方法，一般用于修改等操作，传参放在请求体中，避免明文显示
     *
     * @return 执行结果
     */
    @PostMapping("/update")
    public ResponseEntity<String> testResponseEntity(@RequestBody User user) {
        System.out.println("user: " + user);
        return ResponseEntity.ok("Update success");
    }

    /**
     * Delete 方法一般用于删除功能，restful 风格中，将 id 放在路径参数，望文知意
     *
     * @param id 根据 id 删除
     * @return 删除结果
     */
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") String id) {
        System.out.println("id: " + id);
        return ResponseEntity.ok("Delete [" + id + "] success");
    }

    /**
     * 通过 jackson 自动映射 Map 到实体
     *
     * @param body 请求体
     * @return 结果
     */
    @PostMapping("/auto")
    public ResponseEntity<String> autoConvert(@RequestBody Map<String, Object> body) {
        User user = objectMapper.convertValue(body, User.class);
        System.out.println("user: " + user);
        return ResponseEntity.ok("mapping success");
    }
}
