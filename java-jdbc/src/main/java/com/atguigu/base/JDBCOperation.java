package com.atguigu.base;

import org.junit.Test;

import java.sql.*;

public class JDBCOperation {

    // 获取单行单列
    @Test
    public void testQuerySingleRowAndCol() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///Test", "root", "12345678");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");

        preparedStatement.setInt(1, 3);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String username = resultSet.getString("username");
            System.out.println("用户在数据库的索引为:" + id + "\t 用户的名字为：" + username);

        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
