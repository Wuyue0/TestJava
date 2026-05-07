package com.atguigu.myBatisPlus;


import com.atguigu.myBatisPlus.mapper.UserMapper;
import com.atguigu.myBatisPlus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        // 条件查询构造器QueryWrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "admin");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
