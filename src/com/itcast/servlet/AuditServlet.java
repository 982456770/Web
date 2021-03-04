package com.itcast.servlet;

import com.itcast.pojo.Audit;
import com.itcast.pojo.Meeting;
import com.itcast.service.AuditService;
import com.itcast.service.MeetingService;
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
public class AuditServlet {
	@Autowired
	private AuditService auditService;
	@RequestMapping("/task_management/SelAudit")
	protected void SelAuditbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Audit> list = auditService.selByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			employee.put("time",dateString);
			employee.put("auditid", list.get(j).getAudit_id());
			employee.put("auditSubject", list.get(j).getAuditSubject());
			employee.put("place", list.get(j).getPlace());
			employee.put("class", list.get(j).getClassroom());
			employee.put("other", list.get(j).getOther());
			employee.put("invigilator", list.get(j).getInvigilator());
			employees.add(employee);
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/MOCK/SelAudit")
	protected void SelAuditbyid2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ss");
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Audit> list = auditService.selByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			employee.put("time",dateString);
			employee.put("auditid", list.get(j).getAudit_id());
			employee.put("auditSubject", list.get(j).getAuditSubject());
			employee.put("place", list.get(j).getPlace());
			employee.put("class", list.get(j).getClassroom());
			employee.put("other", list.get(j).getOther());
			employee.put("invigilator", list.get(j).getInvigilator());
			employees.add(employee);
		}
		System.out.println(employees);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/SelDoingAudit")
	protected void SelDoingAuditbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Audit> list = auditService.selByid(id);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			String now=formatter.format(new Date());
			Date sqlDate = java.sql.Date.valueOf(now);// new Date()为获取当前系统时间
			if(date.getTime()>sqlDate.getTime())//比较时间大小,如果dt1大于dt2
			{}
			else
			{
				employee.put("time",dateString);
				employee.put("auditid", list.get(j).getAudit_id());
				employee.put("auditSubject", list.get(j).getAuditSubject());
				employee.put("place", list.get(j).getPlace());
				employee.put("class", list.get(j).getClassroom());
				employee.put("other", list.get(j).getOther());
				employee.put("invigilator", list.get(j).getInvigilator());
				employees.add(employee);
			}
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/SelDoneAudit")
	protected void SelDoneAuditbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		List<Audit> list = auditService.selByid(id);
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
				employee.put("time",dateString);
				employee.put("auditid", list.get(j).getAudit_id());
				employee.put("auditSubject", list.get(j).getAuditSubject());
				employee.put("place", list.get(j).getPlace());
				employee.put("class", list.get(j).getClassroom());
				employee.put("other", list.get(j).getOther());
				employee.put("invigilator", list.get(j).getInvigilator());
				employees.add(employee);
			}
			else
			{ }
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
	@RequestMapping("/task_management/InsAudit")
//	public Object func(@RequestBody List<User> userList)  {
//		// @RequestBody 需要该注解
//		System.out.println(userList);
//		return "audit.html";
//	}
	protected String InsAudit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
		Audit m=new Audit();
		m.setId(id);
		String str =req.getParameter("time");
		java.sql.Date sqlDate = java.sql.Date.valueOf(str);
		m.setTime(sqlDate);
		int length=Integer.valueOf(req.getParameter("length"));
		m.setAuditSubject(req.getParameter("auditSubject"));
		m.setClassroom(req.getParameter("class"));
		m.setPlace(req.getParameter("place"));
		m.setInvigilator(req.getParameter("invigilator"));
		m.setOther(req.getParameter("other"));
		//auditService.insAudit(m);
        for(int j = 0; j < length; j++){
		m.setId(Integer.valueOf(req.getParameter("people[j][id]")));
			auditService.insAudit(m);}
		System.out.println("aap");
		return "audit.html";
	}
	@RequestMapping("/task_management/DelAudit")
	protected String DelAudit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int audit_id=Integer.parseInt(req.getParameter("task_id"));
		System.out.println(audit_id);
		auditService.delaudit(audit_id);
		System.out.println("qq");//task_id=undefined,删除的bug
		return "audit.html";
	}
}