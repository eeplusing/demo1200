package com.eplusing.demo1200.leetcode.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        Connection connection = null;
        //PreparedStatement????????Statement?????Statement?????????????
        //PreparedStatement???sql???????????????
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //?????????????
            Class.forName("com.mysql.jdbc.Driver");

            //????????????????????????
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "admin", "admin");
            //????sql??? ????????
            String sql = "select * from user where username = ?";
            //????????statement
            preparedStatement = connection.prepareStatement(sql);
            //???�???????????????sql????????????????1??????????????????????????
            preparedStatement.setString(1, "????");
            //?????????sql?????????????????
            resultSet = preparedStatement.executeQuery();
            //????????????
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //??????
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

    }

}
