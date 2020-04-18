package com.daydream.platform;

import com.daydream.platform.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlatformApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        userMapper.selectList(null).forEach(System.out::println);
    }

}
