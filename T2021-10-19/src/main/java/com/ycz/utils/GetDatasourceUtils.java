package com.ycz.utils;/*
 @author ycz
 @date 2021-10-21-9:59
*/

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class GetDatasourceUtils {

    private static Properties pp;

    public static DataSource getC3p0(){
        return new ComboPooledDataSource();
    }


    //获得Druid的数据源对象
    static {
        try {
            pp=new Properties();
            pp.load(GetDatasourceUtils.class.getResourceAsStream("T2021-10-19\\druid.properties"));
        }catch (Exception e){
            System.out.println("没有");
        }
    }

    public static DataSource getDruid() throws Exception {
        DataSource ds = DruidDataSourceFactory.createDataSource(pp);
        return ds;
    }

    public static void main(String[] args) throws Exception {
//        DataSource c3p0 = getC3p0();
//        Connection connection = c3p0.getConnection();
//        System.out.println(connection);

        Connection connection = getDruid().getConnection();
        System.out.println(connection);


    }

}
