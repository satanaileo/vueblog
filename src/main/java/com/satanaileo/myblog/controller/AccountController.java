package com.satanaileo.myblog.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.satanaileo.myblog.common.dto.LoginDto;
import com.satanaileo.myblog.common.lang.Result;
import com.satanaileo.myblog.entity.User;
import com.satanaileo.myblog.service.IUserService;
import com.satanaileo.myblog.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * satanaileo
 * 2022/9/7 15:47
 */
@RestController
public class AccountController {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IUserService iUserService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody(required = false) LoginDto loginDto, HttpServletResponse response) {
        User user = iUserService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user, "用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map());
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
