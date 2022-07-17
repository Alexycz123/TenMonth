package com.ycz.service;/*
 @author ycz
 @date 2021-10-19-19:44
*/

import com.ycz.pojo.UserCollect;

import java.sql.SQLException;

public interface UserCollectService {

    int addUserCollect(UserCollect userCollect) throws SQLException;

}
