package com.itcast.service;

import com.itcast.pojo.Audit;
import com.itcast.pojo.Meeting;
import net.sf.json.JSONArray;

import java.util.List;

public interface AuditService {
    List<Audit> selByid(int id);
    List<Audit> selByauditid(int audit_id);
    int insAudit(Audit audit);
    int delaudit(int audit_id);
    List<Audit> show();
}
