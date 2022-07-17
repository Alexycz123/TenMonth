package com.ycz.service;/*
 @author ycz
 @date 2021-10-19-18:32
*/

import com.ycz.pojo.Travel;

import java.sql.SQLException;

public interface TravelService {

    int addTravel(Travel travel) throws SQLException;

}
