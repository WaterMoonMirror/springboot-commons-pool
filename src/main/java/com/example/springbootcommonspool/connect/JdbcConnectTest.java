package com.example.springbootcommonspool.connect;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/1 09:35
 * @description:
 */
@Log4j2
public class JdbcConnectTest {
    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodev?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "123456");
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("select * from stu");
        while (resultSet.next()){
            final int id = resultSet.getInt("id");
            final String name = resultSet.getString("name");
            final String age = resultSet.getString("age");
           log.info("id-{},name-{},age-{}",id,name,age);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
