package com.ycz.util;/*
 @author ycz
 @date 2021-10-13-16:33
*/

import com.ycz.annotation.ImportDbProperties;

import java.util.Properties;

@ImportDbProperties("db.properties")
public class DbUtil {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public  void show(){
        System.out.println(properties);
    }
}
