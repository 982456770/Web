package com.itcast.pojo;

import java.sql.Date;

public class Meeting {
	private int meeting_id;
	private int id;
	private String theme;
	private Date time;
	private String place;
	private String content;
	private String other;
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Meeting [meeting_id=" + meeting_id + ", id=" + id + ", theme=" + theme + ", time=" + time + ", place="
				+ place + ", content=" + content + ", other=" + other + "]";
	}

}
