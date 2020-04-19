package com.itcast.servlet;

import com.itcast.pojo.Notice;
import com.itcast.service.NoticeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class NoticeServlet {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/task_management/SelNotice")
    protected void SelNoticebyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession hs=req.getSession();
        int id=(int) hs.getAttribute("id");
        List<Notice> list = noticeService.selByid(id);
        JSONArray employees = new JSONArray();      //JSON数组
        JSONObject employee = new JSONObject();     //JSON对象
        for(int j=0;j<list.size();j++)
        {
            Date date=list.get(j).getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            employee.put("time",dateString);
            employee.put("noticeid", list.get(j).getNotice_id());
            employee.put("theme", list.get(j).getTheme());
            employee.put("place", list.get(j).getPlace());
            employee.put("content", list.get(j).getContent());
            employee.put("other", list.get(j).getOther());
            employees.add(employee);
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(employees);
    }
    @RequestMapping("/task_management/MOCK/SelNotice")
    protected void SelNoticebyid2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ss");
        req.setCharacterEncoding("utf-8");
        HttpSession hs=req.getSession();
        int id=(int) hs.getAttribute("id");
        List<Notice> list = noticeService.selByid(id);
        JSONArray employees = new JSONArray();      //JSON数组
        JSONObject employee = new JSONObject();     //JSON对象
        for(int j=0;j<list.size();j++)
        {
            Date date=list.get(j).getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            employee.put("time",dateString);
            employee.put("noticeid", list.get(j).getNotice_id());
            employee.put("theme", list.get(j).getTheme());
            employee.put("place", list.get(j).getPlace());
            employee.put("content", list.get(j).getContent());
            employee.put("other", list.get(j).getOther());
            employees.add(employee);
        }
        System.out.println(employees);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(employees);
    }
    @RequestMapping("/task_management/SelDoingNotice")
    protected void SelDoingNoticebyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession hs=req.getSession();
        int id=(int) hs.getAttribute("id");
        List<Notice> list = noticeService.selByid(id);
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
                employee.put("noticeid", list.get(j).getNotice_id());
                employee.put("time",dateString);
                employee.put("theme", list.get(j).getTheme());
                employee.put("place", list.get(j).getPlace());
                employee.put("content", list.get(j).getContent());
                employee.put("other", list.get(j).getOther());
                employees.add(employee);
            }
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(employees);
    }
    @RequestMapping("/task_management/SelDoneNotice")
    protected void SelDoneNoticebyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession hs=req.getSession();
        int id=(int) hs.getAttribute("id");
        List<Notice> list = noticeService.selByid(id);
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
                employee.put("noticeid", list.get(j).getNotice_id());
                employee.put("time",dateString);
                employee.put("theme", list.get(j).getTheme());
                employee.put("place", list.get(j).getPlace());
                employee.put("content", list.get(j).getContent());
                employee.put("other", list.get(j).getOther());
                employees.add(employee);
            }
            else
            { }
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(employees);
    }
    @RequestMapping("/task_management/InsNotice")
//	public Object func(@RequestBody List<User> userList)  {
//		// @RequestBody 需要该注解
//		System.out.println(userList);
//		return "notice.html";
//	}
    protected String InsNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession hs=req.getSession();
        int id=(int) hs.getAttribute("id");
        Notice m=new Notice();
        m.setId(id);
        String str =req.getParameter("time");
        java.sql.Date sqlDate = java.sql.Date.valueOf(str);
        m.setTime(sqlDate);
        int length=Integer.valueOf(req.getParameter("length"));
        m.setTheme(req.getParameter("theme"));
        m.setPlace(req.getParameter("place"));
        m.setContent(req.getParameter("content"));
        m.setOther(req.getParameter("other"));
        for(int j = 0; j < length; j++){
            m.setId(Integer.valueOf(req.getParameter("people[j][id]")));
            noticeService.insNotice(m);}
        System.out.println("aap");
        return "notice.html";
    }
    @RequestMapping("/task_management/DelNotice")
    protected String DelNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int notice_id=Integer.parseInt(req.getParameter("task_id"));
        System.out.println(notice_id);
        noticeService.delNotice(notice_id);
        System.out.println("qq");//task_id=undefined,删除的bug
        return "notice.html";
    }
}