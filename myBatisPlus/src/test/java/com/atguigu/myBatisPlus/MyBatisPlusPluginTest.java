package com.atguigu.myBatisPlus;


import com.atguigu.myBatisPlus.mapper.UserMapper;
import com.atguigu.myBatisPlus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(3, 1);
        userMapper.selectPage(page, null);
        System.out.println("记录数:" + page.getRecords());
        System.out.println("总页数:" + page.getPages());
        System.out.println("总个数:" + page.getTotal());
        System.out.println("是否有下一页:" + page.hasNext());
        System.out.println("是否有上一页:" + page.hasPrevious());
    }

    @Test
    public void testPage2(){
        Page<User> page = new Page<>(1, 5);
        // 根据条件来查询结果并分页 自定义的sql语句 数据库没有age字段 先把password传递进去
        // 在sql语句中使用password 来判断
        userMapper.selectPageByAge(page, 123456);
        System.out.println("记录数:" + page.getRecords());
        System.out.println("总页数:" + page.getPages());
        System.out.println("总个数:" + page.getTotal());
        System.out.println("是否有下一页:" + page.hasNext());
        System.out.println("是否有上一页:" + page.hasPrevious());
    }
}
