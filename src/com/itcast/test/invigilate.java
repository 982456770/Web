package com.itcast.test;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itcast.service.impl.AuditServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.pojo.Invigilate;
import com.itcast.pojo.Meeting;
import com.itcast.service.impl.InvigilateServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class invigilate {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AuditServiceImpl bean = ac.getBean("auditService",AuditServiceImpl.class);

		System.out.println(bean.selByauditid(1));

	}
}
