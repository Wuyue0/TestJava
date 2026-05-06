package com.atguigu.myBatisPlus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

// 设置实体类所对应的表名字
// @TableName("tags")
@Data
public class User {

    // 注解的value 指定主键的字段 type = IdType.AUTO 使用自增
    @TableId(value = "id", type = IdType.AUTO) // 设置主键
    private Long id;

    //@TableField("name") // 指定数据库字段名
    private String username;

    private String password;

    private String createdAt;

    // 逻辑删除字段 会自动加上
//    @TableLogic
//    private Integer isDeleted;
}
