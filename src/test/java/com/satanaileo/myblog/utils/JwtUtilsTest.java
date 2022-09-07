package com.satanaileo.myblog.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * satanaileo
 * 2022/9/7 10:31
 */
@SpringBootTest
class JwtUtilsTest {
    @Autowired
    JwtUtils jwtUtils; // 这里如果是new出来的对象的话得到的是默认初始值null, 0, null

    @Test
    void generateToken() {

    }

    @Test
    void getClaimByToken() {
    }

    @Test
    void isTokenExpired() {
    }

    @Test
    void getSecret() {
        System.out.println(jwtUtils.getSecret());
    }

    @Test
    void getExpire() {
        System.out.println(jwtUtils.getExpire());
    }

    @Test
    void getHeader() {
    }
}