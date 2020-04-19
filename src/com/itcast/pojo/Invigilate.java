package com.itcast.pojo;

import java.sql.Timestamp;

public class Invigilate {
	private int invigilate_id;
	private int id;
	private String subject;
	private Timestamp time;
	private String place;
	private String classes;
	private String duration_time;
	private String invigilator;
	private String describe;
	public int getInvigilate_id() {
		return invigilate_id;
	}
	public void setInvigilate_id(int invigilate_id) {
		this.invigilate_id = invigilate_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getDuration_time() {
		return duration_time;
	}
	public void setDuration_time(String duration_time) {
		this.duration_time = duration_time;
	}
	public String getInvigilator() {
		return invigilator;
	}
	public void setInvigilator(String invigilator) {
		this.invigilator = invigilator;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "invigilate [invigilate_id=" + invigilate_id + ", id=" + id + ", subject=" + subject + ", time=" + time
				+ ", place=" + place + ", classes=" + classes + ", duration_time=" + duration_time + ", invigilator="
				+ invigilator + ", describe=" + describe + "]";
	}
}
