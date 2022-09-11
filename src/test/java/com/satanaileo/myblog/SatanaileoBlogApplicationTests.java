package com.satanaileo.myblog;

import cn.hutool.crypto.SecureUtil;
import com.satanaileo.myblog.entity.User;
import com.satanaileo.myblog.mapper.UserMapper;
import com.satanaileo.myblog.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

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
    @Test
    void testMd5() {
        String s = SecureUtil.md5("123456");
        System.out.println(s);
    }

    @Test
    void testRedis() {
        Jedis jedis = new Jedis("192.168.191.129");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

}
