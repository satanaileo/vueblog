package com.satanaileo.myblog.service.impl;

import com.satanaileo.myblog.entity.Blog;
import com.satanaileo.myblog.mapper.BlogMapper;
import com.satanaileo.myblog.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author satanaileo
 * @since 2022-08-19
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
