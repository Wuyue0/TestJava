package com.atguigu.base;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

public class JDBCQuick {

    public static void main(String[] args) throws Exception {

        // 1. 加载驱动 一般会自动注册调用 不用
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取链接对象
        String url = "jdbc:mysql://localhost:3306/Test";
        String username = "root";
        String password = "12345678";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 创建Statement对象 prepareStatement可以防止sql 注入的问题
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");

        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        // 注意索引是从1开始算的 一个？ 代表从1
        preparedStatement.setString(1, name);
        ResultSet resultSet  = preparedStatement.executeQuery();
    //  String sql = "select * from users where id = 1" + name;
    //  ResultSet resultSet = statement.executeQuery(sql);

        // 4. 处理结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username1 = resultSet.getString("username");
            String password1 = resultSet.getString("password");
            String createAt = resultSet.getString("created_at");
            System.out.println(id + "\t" + username1 + "\t" + password1 + "\t" + createAt);
        }

        // 5.释放链接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
