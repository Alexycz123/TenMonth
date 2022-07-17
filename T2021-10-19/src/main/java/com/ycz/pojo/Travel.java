package com.ycz.pojo;/*
 @author ycz
 @date 2021-10-19-17:01
*/

public class Travel {

    private Integer id;
    private String name;
    private String address;

    public Travel() {
    }

    public Travel(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
