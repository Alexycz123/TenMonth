package com.ycz.pojo;/*
 @author ycz
 @date 2021-10-12-20:15
*/

public class UserEnity {
    private String name;

    @Override
    public String toString() {
        return "UserEnity{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public UserEnity(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    public UserEnity(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String pwd;
}
