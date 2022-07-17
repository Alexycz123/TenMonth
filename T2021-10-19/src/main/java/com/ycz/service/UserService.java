package com.ycz.service;/*
 @author ycz
 @date 2021-10-19-17:06
*/

import com.ycz.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User selectUser(Integer id) throws SQLException;

    int addUser(User user) throws SQLException;

    List<User> selectAll() throws SQLException;

}
