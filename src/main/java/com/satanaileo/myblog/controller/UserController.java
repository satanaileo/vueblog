package com.satanaileo.myblog.controller;


import com.satanaileo.myblog.entity.User;
import com.satanaileo.myblog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author satanaileo
 * @since 2022-08-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService iUserService;

    @GetMapping("{id}")
    public User testSelect(@PathVariable("id") Long id) {
        User user = iUserService.getById(id);
        return user;
    }

    @PostMapping("/save")
    public Object testUser(@Validated @RequestBody User user) {
        return user.toString();
    }

}
