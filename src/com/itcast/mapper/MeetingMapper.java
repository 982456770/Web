package com.itcast.mapper;

import com.itcast.pojo.Meeting;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MeetingMapper {
	//某个人的
	@Select("select * from meeting where id=#{id}")
	List<Meeting> selByid(int id);
	//某个会议
	@Select("select * from meeting where meeting_id=#{meeting_id}")
	List<Meeting> selBymeetingid(int meeting_id);

	@Insert("insert into meeting values (default,#{id},#{theme},#{time},#{place},#{content},#{other})")
    int insMeeting(Meeting meeting);

	@Select("select * from meeting ")
	List<Meeting> selAll();
	@Delete("delete from meeting where meeting_id=#{meeting_id}")
    int removeMeeting(Integer meeting_id);
}
