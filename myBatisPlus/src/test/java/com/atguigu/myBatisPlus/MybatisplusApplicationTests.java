package com.atguigu.myBatisPlus;

import com.atguigu.myBatisPlus.mapper.UserMapper;
import com.atguigu.myBatisPlus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        // 1.查询所有数据
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
        // 2.查询固定条件查询 根据id来查询user 单个用户
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

        // 3.批量查询用户根据多个id
//        List<Long> ids = Arrays.asList(1L, 2L, 3L);
//        List<User> users1 = userMapper.selectBatchIds(ids);
//        for (User user1 : users1) {
//            System.out.println(user1);
//        }

        // 4.根据map查询 集合中的条件查询 SELECT id,username,password,created_at FROM user WHERE username = ?
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", "zhangsan");
//        map.put("password", "123456");
//        List<User> users2 = userMapper.selectByMap(map);
//        for (User user2 : users2) {
//            System.out.println(user2);
//        }

//        Map<String, Object> map = userMapper.selectMapById(1L);
//        System.out.println(map);

    }

    @Test
    public void testInsert() {
        // 新增用户信息
        // NSERT INTO user ( id, username, password, created_at ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreatedAt("2023-05-05 12:00:00");
        int insert = userMapper.insert(user); // 使用雪花算法 添加id 给mysql
        System.out.println(insert);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        // 修改用户信息
        // UPDATE user SET username=?, password=?, created_at=? WHERE id=?
        User user = new User();
        user.setId(1L);
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreatedAt("2023-05-05 12:00:00");
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

    @Test
    public void testDelete() {
        // 删除用户信息
        // DELETE FROM user WHERE id=?
//        int delete = userMapper.deleteById(4);
//        System.out.println(delete);

        // 根据map删除
        //Map<String, Object> map = new HashMap<>();
        //map.put("username", "张三");
        //map.put("password", "123456");
        //int delete1 = userMapper.deleteByMap(map);

        // 根据id批量删除
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        int delete1 = userMapper.deleteBatchIds(ids);
    }
}
