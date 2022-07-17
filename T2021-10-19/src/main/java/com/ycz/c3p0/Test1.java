package com.ycz.c3p0;/*
 @author ycz
 @date 2021-10-21-9:02
*/

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ycz.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    private ComboPooledDataSource c3p0ds;

    @Before
    public void init(){
        c3p0ds=new ComboPooledDataSource();
        //数据库连接
    }

    @Test
    public void getDst() throws SQLException {
        System.out.println(c3p0ds);
        Connection connection = c3p0ds.getConnection();
        String sql="select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setPwd(resultSet.getString(3));
            user.setPhone(resultSet.getString(4));
            userList.add(user);
        }
        System.out.println(userList);

    }

}
