package com.ycz.utils;/*
 @author ycz
 @date 2021-10-19-17:07
*/

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {

    public Connection getDBConnection() {
        File file = new File("druid.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            System.out.println(properties);

            Class.forName(properties.getProperty("jdbc.driver"));
            return DriverManager.getConnection(
                    properties.get("jdbc.url").toString(),
                    properties.get("jdbc.username").toString(),
                    properties.get("jdbc.password").toString()

            );


            // Class.forName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

