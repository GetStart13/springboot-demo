package springboot.example.server_basic_structure;

import org.springboot.example.server_basic_structure.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest     // 测试类所在包目录与主包目录一致，不用加class
class ServTest {
    @Autowired
    private UserService serviceTest;

    @Test
    void testShow() {
        serviceTest.list();
    }
}
