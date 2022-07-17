package com.ycz.service.impl;/*
 @author ycz
 @date 2021-10-19-18:33
*/

import com.ycz.pojo.Travel;
import com.ycz.service.TravelService;
import com.ycz.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TravelServiceImpl implements TravelService {
    @Override
    public int addTravel(Travel travel) throws SQLException {
        DBUtil dbUtil=new DBUtil();
        Connection dbConnection = dbUtil.getDBConnection();

        String sql="insert into travel (name,address) values (?,?)";

        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        preparedStatement.setString(1, travel.getName());
        preparedStatement.setString(2, travel.getAddress());


        int rs=preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnection.close();
        //dbConnection.close();
        return rs;
    }
}
