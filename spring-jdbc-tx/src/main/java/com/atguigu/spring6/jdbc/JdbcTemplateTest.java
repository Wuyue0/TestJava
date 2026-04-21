package com.atguigu.spring6.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classPath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public  void  testUpdate(){
        // 查询数据
        String sql = "select * from users where id=?";
        jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {
                    // 实例话一个对象 然后 网上边赋值

                     rs.getString("username");
                    return null;
                }, 1);
    }
}
