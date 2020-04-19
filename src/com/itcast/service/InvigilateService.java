package com.itcast.service;

import com.itcast.pojo.Invigilate;

import java.util.List;

public interface InvigilateService {
	List<Invigilate> selinvigilateByid(int id);
	List<Invigilate> selByinvigilateid(int invigilate_id);
	int insInvigilate(Invigilate invigilate);
	int delInvigilate(int invigilate_id);
	List<Invigilate> show();
}
