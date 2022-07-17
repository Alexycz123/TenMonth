package com.ycz.service.impl;/*
 @author ycz
 @date 2021-10-19-17:06
*/

import com.ycz.pojo.User;
import com.ycz.service.UserService;
import com.ycz.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User selectUser(Integer id) throws SQLException {
        DBUtil dbUtil=new DBUtil();
        Connection dbConnection = dbUtil.getDBConnection();
        String sql="select id,name,pwd,phone from user where id=?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while (rs.next()){
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setPwd(rs.getString(3));
            user.setPhone(rs.getString(4));
        }
        preparedStatement.close();
        dbConnection.close();
        return user;
    }

    @Override
    public int addUser(User user) throws SQLException {
        DBUtil dbUtil=new DBUtil();
        Connection dbConnection = dbUtil.getDBConnection();

        String sql="insert into user (name,pwd,phone) values (?,?,?)";

        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPwd());
        preparedStatement.setString(3, user.getPhone());

        int rs=preparedStatement.executeUpdate();

        //dbConnection.close();
        preparedStatement.close();
        dbConnection.close();

        return rs;
    }

    @Override
    public List<User> selectAll() throws SQLException {
        DBUtil dbUtil=new DBUtil();
        Connection dbConnection = dbUtil.getDBConnection();
        String sql="select id,name,pwd,phone from user";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();
       List<User> userList=new ArrayList<>();
        while (rs.next()){
            User user=new User();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setPwd(rs.getString(3));
            user.setPhone(rs.getString(4));
            userList.add(user);
        }
        preparedStatement.close();
        dbConnection.close();

        return userList;
    }
}
