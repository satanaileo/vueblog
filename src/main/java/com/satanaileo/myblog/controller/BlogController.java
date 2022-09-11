package com.satanaileo.myblog.controller;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.satanaileo.myblog.common.lang.Result;
import com.satanaileo.myblog.entity.Blog;
import com.satanaileo.myblog.service.IBlogService;
import com.satanaileo.myblog.utils.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author satanaileo
 * @since 2022-08-19
 */
@RestController
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blogs")
    public Result blogs(Integer currentPage) {
        if (currentPage == null || currentPage < 1) currentPage = 1;
        Page<Blog> page = new Page<>(currentPage, 5);
        IPage<Blog> pageData = iBlogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.succ(pageData);
    }

    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable("id") Long id) {
        Blog blog = iBlogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");

        return Result.succ(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog) {
        Blog tmp = null;
        if (blog.getId() != null) {
            tmp = iBlogService.getById(blog.getId());
            Assert.isTrue(tmp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(),
                    "没有编辑权限");
        } else {
            tmp = new Blog();
            tmp.setUserId(ShiroUtil.getProfile().getId());
            tmp.setCreated(LocalDateTime.now());
            tmp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, tmp, "id", "userId", "created", "status");
        tmp.setLastLogin(LocalDateTime.now());
        iBlogService.saveOrUpdate(tmp);
        return Result.succ(null);
    }

}
