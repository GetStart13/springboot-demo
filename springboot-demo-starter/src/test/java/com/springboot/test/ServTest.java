package com.springboot.test;

import com.springboot.springboot_primary.service.ServiceTest;
import com.springboot.SpringbootDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 *serviceTest的测试类
 */
@SpringBootTest(classes = SpringbootDemoApplication.class)   //如果测试类所在包目录与主包目录不一致，要加class
public class ServTest {

    @Autowired
    private ServiceTest serviceTest;
    @Test
    public void testShow(){
        serviceTest.show();
    }
}
