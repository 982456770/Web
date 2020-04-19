package com.itcast.pojo;

import java.sql.Date;

public class Notice {
    private int notice_id;
    private int id;
    private String theme;
    private String place;
    private String content;
    private Date time;
    private String other;

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", id=" + id +
                ", theme='" + theme + '\'' +
                ", place='" + place + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
