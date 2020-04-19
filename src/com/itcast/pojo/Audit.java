package com.itcast.pojo;

import java.sql.Timestamp;

public class Audit {
    private int audit_id;
    private int id;
    private String auditSubject;
    private String place;
    private String classroom;
    private String invigilator;
    private Timestamp time;
    private String other;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(int audit_id) {
        this.audit_id = audit_id;
    }

    public String getAuditSubject() {
        return auditSubject;
    }

    public void setAuditSubject(String auditSubject) {
        this.auditSubject = auditSubject;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(String invigilator) {
        this.invigilator = invigilator;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
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
        return "Audit{" +
                "audit_id=" + audit_id +
                ", id=" + id +
                ", auditSubject='" + auditSubject + '\'' +
                ", place='" + place + '\'' +
                ", classroom='" + classroom + '\'' +
                ", invigilator='" + invigilator + '\'' +
                ", time=" + time +
                ", other='" + other + '\'' +
                '}';
    }
}
