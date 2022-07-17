package com.ycz.test;/*
 @author ycz
 @date 2021-10-14-11:26
*/

import com.ycz.factory.SpringBeanFactory;
import com.ycz.service.StudentService;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Test1 {
    @Test
    public void t1() throws IOException {
        ClassLoader classLoader = Test1.class.getClassLoader();
        URL resource = classLoader.getResource("");
        String url=resource.getPath();
        System.out.println(url);

        String path = classLoader.getResource("db.properties").getPath();

        System.out.println(path);


        InputStream inputStream = classLoader.getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        System.out.println(properties);
    }

    @Test
    public void t3() throws Exception {
        StudentService studentServiceImpl =
                (StudentService) SpringBeanFactory.getBean("StudentServiceImpl2");
        studentServiceImpl.add();
    }



}
