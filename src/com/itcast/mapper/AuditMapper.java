package com.itcast.mapper;

import com.itcast.pojo.Audit;
import com.itcast.pojo.Meeting;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuditMapper {
	//某个人的
	@Select("select * from audit where id=#{id}")
	List<Audit> selByid(int id);
	//某个会议
	@Select("select * from audit where audit=#{audit}")
	List<Audit> selByauditid(int audit_id);
	
	
	@Insert("insert into meeting values (default,#{id},#{auditSubject},#{time},#{place},#{classroom},#{invigilator},#{other})")
    int insAudit(Audit audit);

	@Delete("delete from meeting where audit_id=#{audit_id}")
    int removeAudit(Integer audit_id);
}
