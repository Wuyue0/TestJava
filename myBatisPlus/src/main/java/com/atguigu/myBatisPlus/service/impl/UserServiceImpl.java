package com.atguigu.myBatisPlus.service.impl;

import com.atguigu.myBatisPlus.mapper.UserMapper;
import com.atguigu.myBatisPlus.pojo.User;
import com.atguigu.myBatisPlus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
