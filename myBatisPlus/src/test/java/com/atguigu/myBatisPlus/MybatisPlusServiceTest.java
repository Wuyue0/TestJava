package com.atguigu.myBatisPlus;


import com.atguigu.myBatisPlus.pojo.User;
import com.atguigu.myBatisPlus.service.UserService;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void testGetCount() {
        // 查询总的记录数量
        long count = userService.count();
        System.out.println("总记录数：" + count);

        // 获取 MP 的表信息
        TableInfo tableInfo = TableInfoHelper.getTableInfo(User.class);
        // 打印主键策略
        System.out.println("MP 识别到的主键策略是: " + tableInfo.getIdType());


    }
    // 批量添加用户 通过saveBatch
    @Test
    public void testInsertMore() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            User user = new User();
            user.setUsername("wuyue11" + i);
            user.setPassword("123456");
            user.setCreatedAt("2023-05-05 12:00:00");
            list.add(user);
        }
        boolean result = userService.saveBatch(list);
        System.out.println("result：" + result);

    }
}
