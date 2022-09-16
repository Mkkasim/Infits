package com.mk.infits.model.live;

import android.widget.ImageView;

public class LiveUpcomingModel {

    //homeban1
    String userName,liveDate,liveTime;
    int viewersImg;


    public LiveUpcomingModel(String userName, String liveDate, String liveTime) {
        this.userName = userName;
        this.liveDate = liveDate;
        this.liveTime = liveTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(String liveDate) {
        this.liveDate = liveDate;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }

    public LiveUpcomingModel(int viewersImg) {
        this.viewersImg = viewersImg;
    }

    public int getViewersImg() {
        return viewersImg;
    }

    public void setViewersImg(int viewersImg) {
        this.viewersImg = viewersImg;
    }
}
