package com.itcast.service;

import com.itcast.pojo.Meeting;
import com.itcast.pojo.Notice;
import net.sf.json.JSONArray;

import java.util.List;

public interface NoticeService {
    List<Notice> selByid(int id);
    List<Notice> selBynotice_id(int notice_id);
    int insNotice(Notice notice);
    int delNotice(int notice_id);
}
