package com.springboot.springboot_primary;

import com.springboot.springboot_primary.service.ServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest     //测试类所在包目录与主包目录一致，不用加class
public class ServTest {
    @Autowired
    private ServiceTest serviceTest;
    @Test
    public void testShow(){
        serviceTest.show();
    }
}
