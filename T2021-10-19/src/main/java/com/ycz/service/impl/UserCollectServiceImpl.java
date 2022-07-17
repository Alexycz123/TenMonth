package com.ycz.service.impl;/*
 @author ycz
 @date 2021-10-19-19:46
*/

import com.ycz.pojo.UserCollect;
import com.ycz.service.UserCollectService;
import com.ycz.utils.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserCollectServiceImpl implements UserCollectService {
    @Override
    public int addUserCollect(UserCollect userCollect) throws SQLException {

        DBUtil dbUtil=new DBUtil();
        Connection dbConnection = dbUtil.getDBConnection();
        String sql="insert into user_collect () values(?,?,?)";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        preparedStatement.setInt(1,userCollect.getUserId());
        preparedStatement.setInt(2,userCollect.getTravelId());

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        preparedStatement.setString(3, (sdf.format(date)));

        int rs=preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnection.close();
        return rs;


    }
}
