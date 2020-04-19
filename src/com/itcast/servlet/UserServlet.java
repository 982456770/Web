package com.itcast.servlet;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("")
public class UserServlet {
	@Autowired
	private UserService userService;
	@RequestMapping("modifyUser")
	protected String modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
//		String sessionId = hs.getId();
//		System.out.println("sessionId:"+sessionId);
		int id=(int) hs.getAttribute("id");
		//System.out.println("id="+id);
		User users = new User();
		users.setId(id);
		users.setAddress(req.getParameter("addr"));
		String birth=req.getParameter("birth");
		Date date = Date.valueOf(birth);
		users.setBirth(date);
		users.setEmail(req.getParameter("email"));
		users.setGender(req.getParameter("gender"));
		users.setName(req.getParameter("name"));
		users.setNickname(req.getParameter("nikename"));
		String tel=req.getParameter("tel");
		int phone=Integer.parseInt(tel);
		users.setPhone(phone);
		userService.modifyUser(users);
		return "personal_center_personal_data.html";
	}
	@RequestMapping("selUser")
	protected void selUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		int id=(int) hs.getAttribute("id");
//		System.out.println(id+"--");
		User a=userService.seluserByid(id);
		JSONObject json= new JSONObject();
		json.put("nikename", a.getNickname());
		json.put("tel", a.getPhone());
		json.put("name", a.getName());
		json.put("gender", a.getGender());
		json.put("email", a.getEmail());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(a.getBirth());
		json.put("birth", dateStr);
		json.put("addr", a.getAddress());
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(json);
	}
	@RequestMapping("/task_management/SendName")//收写到上面的ins里，用户的穿和sel上面一样
	protected void name(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dwef2");
		List<User> list = userService.show();
		System.out.println(list);
		JSONArray employees = new JSONArray();      //JSON数组
		JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			employee.put("id", list.get(j).getId());
			employee.put("name", list.get(j).getName());
			employees.add(employee);
		}
		System.out.println(employees);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(employees);
	}
}