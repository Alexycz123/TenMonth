package com.ycz.pojo;/*
 @author ycz
 @date 2021-10-19-19:42
*/

import java.util.Date;

public class UserCollect {
    private Integer userId;
    private Integer travelId;
    private Date   createTime;

    public UserCollect(){

    }

    @Override
    public String toString() {
        return "UserCollect{" +
                "userId=" + userId +
                ", travelId=" + travelId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserCollect(Integer userId, Integer travelId, Date createTime) {
        this.userId = userId;
        this.travelId = travelId;
        this.createTime = createTime;
    }
}
