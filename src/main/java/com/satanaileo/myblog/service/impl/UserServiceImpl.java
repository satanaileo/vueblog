package com.satanaileo.myblog.service.impl;

import com.satanaileo.myblog.entity.User;
import com.satanaileo.myblog.mapper.UserMapper;
import com.satanaileo.myblog.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
