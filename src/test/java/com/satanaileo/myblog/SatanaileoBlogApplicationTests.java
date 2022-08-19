package com.satanaileo.myblog;

import com.satanaileo.myblog.entity.User;
import com.satanaileo.myblog.mapper.UserMapper;
import com.satanaileo.myblog.service.IUserService;
import org.apache.velocity.runtime.directive.Foreach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.util.List;

@SpringBootTest
class SatanaileoBlogApplicationTests {
    @Autowired
    IUserService iUserService;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setAvatar("abc");
        user.setPassword("123");
        user.setEmail("123");
        user.setStatus(1);
        user.setUsername("abc");
        boolean insert = iUserService.save(user);
        System.out.println(insert);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
