package com.itcast.service.impl;


import com.itcast.mapper.NoticeMapper;
import com.itcast.pojo.Notice;
import com.itcast.service.NoticeService;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    private NoticeMapper noticeMapper;

    public NoticeMapper getNoticeMapper() {
        return noticeMapper;
    }

    public void setNoticeMapper(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public List<Notice> selByid(int id) {
        return noticeMapper.selByid(id);
    }

    @Override
    public List<Notice> selBynotice_id(int notice_id) {
        return noticeMapper.selBynotice_id(notice_id);
    }

    @Override
    public int insNotice(Notice notice) {
        noticeMapper.insNotice(notice);
        return 0;
    }

    @Override
    public int delNotice(int notice_id) {
        noticeMapper.delNotice(notice_id);
        return 0;
    }


}
