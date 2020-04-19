package com.itcast.mapper;


import com.itcast.pojo.Notice;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeMapper {
    //某个人的
    @Select("select * from notice where id=#{id}")
    List<Notice> selByid(int id);
    //某个通知
    @Select("select * from notice where notice_id=#{notice_id}")
    List<Notice> selBynotice_id(int notice_id);
    @Insert("insert into notice values (default,#{id},#{theme},#{place},#{banji},#{time},#{content},#{other})")
    int insNotice(Notice notice);
    //
    @Select("select * from notice ")
    List<Notice> selAll();
    @Delete("delete from notice where notice_id=#{notice_id}")
    int delNotice(int notice_id);
}
