package com.itcast.pojo;

import java.sql.Date;

public class Notice {
    private int notice_id;
    private int id;
    private String theme;
    private String place;
    private Date time;
    private String content;
    private String other;
    private String description;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", id=" + id +
                ", theme='" + theme + '\'' +
                ", place='" + place + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", other='" + other + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
