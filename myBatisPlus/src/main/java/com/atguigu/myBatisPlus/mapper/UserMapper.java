package com.atguigu.myBatisPlus.mapper;

import com.atguigu.myBatisPlus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapById(@Param("id") Long id);
    /**
     * 通过年龄查询用户信息并分页
     * @param page
     * @param age
     * @return
     */
    Page<User> selectPageByAge(@Param("page") Page<User> page, @Param("age") Integer age);
}
