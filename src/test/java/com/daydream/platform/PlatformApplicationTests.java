package com.daydream.platform;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.daydream.platform.entity.User;
import com.daydream.platform.mapper.UserMapper;
import com.daydream.platform.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlatformApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        System.out.println(userMapper.selectOne(new QueryWrapper<User>().eq("username", "lic")));
    }

    @Test
    public void test1() {
        System.out.println(userService.getById("3a08e279219445823276b2fbefc2d5a0").toString());
    }
}
