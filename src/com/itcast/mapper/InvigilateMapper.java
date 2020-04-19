package com.itcast.mapper;

import com.itcast.pojo.Invigilate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InvigilateMapper {
	//某个人的
		@Select("select * from invigilate where id=#{id}")
		List<Invigilate> selinvigilateByid(int id);
		//某个会议
		@Select("select * from invigilate where invigilate_id=#{invigilate_id}")
		List<Invigilate> selByinvigilateid(int invigilate_id);
		
		@Insert("insert into invigilate values (default,#{id},#{subject},#{time},#{place},#{classes},#{duration_time},#{invigilator},#{describe})")
		int insMeeting(Invigilate invigilate);
		//
		@Select("select * from invigilate ")
		List<Invigilate> selAll();
		@Delete("delete from invigilate where invigilate_id=#{invigilate_id}")
		int removeInvigilateid(Integer invigilate_id);
}
