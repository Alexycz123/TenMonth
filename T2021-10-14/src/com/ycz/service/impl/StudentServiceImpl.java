package com.ycz.service.impl;/*
 @author ycz
 @date 2021-10-14-15:17
*/

import com.ycz.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public void add() {
        System.out.println("add的方法");
    }

    @Override
    public void update() {
        System.out.println("更新的方法");
    }
}
