package com.itcast.service.impl;

import java.util.List;

import com.itcast.mapper.AuditMapper;
import com.itcast.mapper.MeetingMapper;
import com.itcast.pojo.Audit;
import com.itcast.pojo.Meeting;
import com.itcast.service.AuditService;
import com.itcast.service.MeetingService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AuditServiceImpl implements AuditService {
    private AuditMapper auditMapper;

    public AuditMapper getAuditMapper() {
        return auditMapper;
    }
    public void setAuditMapper(AuditMapper auditMapper) {
        this.auditMapper = auditMapper;
    }
    public int delaudit(int audit_id) {
        return auditMapper.removeAudit(audit_id);
    }
    public List<Audit> selByid(int id) {
        return auditMapper.selByid(id);
    }
    public List<Audit> selByauditid(int audit_id) {
        return auditMapper.selByauditid(audit_id);
    }
    public int insAudit(Audit audit) {return auditMapper.insAudit(audit);}
    public List<Audit> show() {
        return auditMapper.selAll();
    }
}
