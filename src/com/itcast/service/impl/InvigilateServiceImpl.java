package com.itcast.service.impl;

import com.itcast.mapper.InvigilateMapper;
import com.itcast.pojo.Invigilate;
import com.itcast.service.InvigilateService;

import java.util.List;

public class InvigilateServiceImpl implements InvigilateService{
	private InvigilateMapper invigilateMapper;

	public InvigilateMapper getInvigilateMapper() {
		return invigilateMapper;
	}
	public void setInvigilateMapper(InvigilateMapper invigilateMapper) {
		this.invigilateMapper = invigilateMapper;
	}
	
	
	public List<Invigilate> selinvigilateByid(int id) {
		return invigilateMapper.selinvigilateByid(id);
	}
	public List<Invigilate> selByinvigilateid(int invigilate_id) {
		return invigilateMapper.selByinvigilateid(invigilate_id);
	}
	public int insInvigilate(Invigilate invigilate_id) {
        return invigilateMapper.insMeeting(invigilate_id);
    }

	@Override
	public int delInvigilate(int invigilate_id) {
		return invigilateMapper.removeInvigilateid(invigilate_id);
	}

	public List<Invigilate> show() {
		return invigilateMapper.selAll();
	}

}
