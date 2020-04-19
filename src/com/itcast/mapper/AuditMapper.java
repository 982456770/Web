package com.itcast.mapper;

import com.itcast.pojo.Audit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuditMapper {
	//某个人的
	@Select("select * from audit where id=#{id}")
	List<Audit> selByid(int id);
	//某个会议
	@Select("select * from audit where audit_id=#{audit_id}")
	List<Audit> selByauditid(int audit_id);

	@Insert("insert into audit values (default,#{id},#{auditSubject},#{time},#{place},#{invigilator},#{classroom},#{other})")
    int insAudit(Audit audit);

	@Select("select * from audit ")
	List<Audit> selAll();
	@Delete("delete from audit where audit_id=#{audit_id}")
    int removeAudit(Integer audit_id);
}
