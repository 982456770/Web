package com.itcast.servlet;

import com.itcast.pojo.Invigilate;
import com.itcast.service.InvigilateService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class InvigilateServlet {
	@Autowired
	private InvigilateService invigilateService;
	@RequestMapping("/task_management/SelInvigilate")
	protected void SelInvigilatebyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Invigilate> list = invigilateService.selinvigilateByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			employee.put("time",dateString);
			employee.put("invigilate_id", list.get(j).getInvigilate_id());
			employee.put("subject", list.get(j).getSubject());
			employee.put("place", list.get(j).getPlace());
			employee.put("class", list.get(j).getClass());
			employee.put("duration_time", list.get(j).getDuration_time());
			employee.put("invigilator", list.get(j).getInvigilator());
			employee.put("describe", list.get(j).getDescribe());
			employees.add(employee);
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/MOCK/SelInvigilate")
	protected void SelInvigilatebyid2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Invigilate> list = invigilateService.selinvigilateByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			employee.put("time",dateString);
			employee.put("invigilate_id", list.get(j).getInvigilate_id());
			employee.put("subject", list.get(j).getSubject());
			employee.put("place", list.get(j).getPlace());
			employee.put("class", list.get(j).getClass());
			employee.put("duration_time", list.get(j).getDuration_time());
			employee.put("invigilator", list.get(j).getInvigilator());
			employee.put("describe", list.get(j).getDescribe());
			employees.add(employee);
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/SelDoingInvigilate")
	protected void SelDoingInvigilatebyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Invigilate> list = invigilateService.selinvigilateByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			String now=formatter.format(new Date());
			Date sqlDate = java.sql.Date.valueOf(now);
			if(date.getTime()>sqlDate.getTime())//比较时间大小,如果dt1大于dt2
			{ }
			else
			{
				employee.put("time",dateString);
				employee.put("invigilate_id", list.get(j).getInvigilate_id());
				employee.put("subject", list.get(j).getSubject());
				employee.put("place", list.get(j).getPlace());
				employee.put("class", list.get(j).getClass());
				employee.put("duration_time", list.get(j).getDuration_time());
				employee.put("invigilator", list.get(j).getInvigilator());
				employee.put("describe", list.get(j).getDescribe());
				employees.add(employee);
			}
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/SelDoneInvigilate")
	protected void SelDoneInvigilatebyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Invigilate> list = invigilateService.selinvigilateByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			String now=formatter.format(new Date());
			Date sqlDate = java.sql.Date.valueOf(now);
			if(date.getTime()>sqlDate.getTime())//比较时间大小,如果dt1大于dt2
			{
				employee.put("invigilate_id", list.get(j).getInvigilate_id());
				employee.put("time",dateString);
				employee.put("subject", list.get(j).getSubject());
				employee.put("place", list.get(j).getPlace());
				employee.put("class", list.get(j).getClass());
				employee.put("duration_time", list.get(j).getDuration_time());
				employee.put("invigilator", list.get(j).getInvigilator());
				employee.put("describe", list.get(j).getDescribe());
				employees.add(employee);
			}
			else
			{ }
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/InsInvigilate")
	protected String InsInvigilate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		Invigilate m=new Invigilate();
		m.setId(id);
		String str =req.getParameter("time");
		java.sql.Date sqlDate = java.sql.Date.valueOf(str);
		m.setTime(sqlDate);
		m.setSubject(req.getParameter("examSubject"));
		m.setPlace(req.getParameter("place"));
		m.setDuration_time(req.getParameter("durationTime"));
		m.setClasses(req.getParameter("class"));
		m.setInvigilator(req.getParameter("invigilator"));
		m.setDescribe(req.getParameter("other"));
		int length=Integer.valueOf(req.getParameter("length"));
		for(int j = 0; j < length; j++){
			m.setId(Integer.valueOf(req.getParameter("people[j][id]")));
			invigilateService.insInvigilate(m);}
		return "/task_management/invigilate.html";
	}
	@RequestMapping("/task_management/DelInvigilate")
	protected String DelInvigilate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int meeting_id=Integer.parseInt(req.getParameter("task_id"));
		System.out.println(meeting_id);
		invigilateService.delInvigilate(meeting_id);
		System.out.println("qq");//task_id=undefined,删除的bug
		return "meeting.html";
	}
}