package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ExamService;
import com.service.UserService;
import com.entity.Exam;
import com.entity.User;
import com.entity.UserExamKey;

@Controller
@SessionAttributes("exam")
public class ExamHandler {
@Autowired
ExamService examService;
@Autowired
UserService userService;

@RequestMapping("/addexam")
public String addExam(Exam exam,Model m,HttpServletRequest request,String startTim,String endTim){
	startTim=startTim.replace("T", " ");
	endTim=endTim.replace("T", " ");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	Date startTime=null;
	Date endTime=null;
	try {
		startTime = formatter.parse(startTim);
		endTime=formatter.parse(endTim);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	exam.setEndTime(endTime);
	exam.setStartTime(startTime);
	examService.addExam(exam);
	JOptionPane.showMessageDialog(null, "已添加新的考试信息！"); 
	m.addAttribute("exam", exam);
	return "examadd";
}
@RequestMapping("/listexam/{page}")
public String getAll(Map<String,Object> map,@PathVariable("page")int page,HttpSession session){
	PageHelper.startPage(page, 99);
	PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(examService.listExam());
	System.out.println(pageInfo);
	System.out.println(pageInfo.getList());
	map.put("pageInfo", pageInfo);
	return "examlist";
}

@ResponseBody
@RequestMapping(value="/getuser/{id}",produces="text/html;charset=UTF-8")
public String getAllUser(@PathVariable("id") Integer id){
	String str=examService.getUser(id);
	System.out.println(str);
	return str;
	}
@ResponseBody
@RequestMapping(value="/getexam/{id}",produces="text/html;charset=UTF-8")
public String getAllExam(@PathVariable("id") Integer id){
	String str=examService.getExam(id);
	System.out.println(str);
	return str;
	}
@RequestMapping("examallot/{page}")
public String getUserNum(Map<String,Object> map,@PathVariable("page")int page,Model m,HttpSession session){
	PageHelper.startPage(page, 100);
	PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(examService.getUserNum());
	System.out.println(pageInfo);
	System.out.println(pageInfo.getList());
	map.put("pageInfo", pageInfo);
	m.addAttribute("pageInfo", pageInfo);
	return "examAllot";
}
@RequestMapping("examallotchange/{page}")
public String getUserNum1(Map<String,Object> map,@PathVariable("page")int page,Model m,HttpSession session){
	PageHelper.startPage(page, 100);
	PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(examService.getUserNum());
	System.out.println(pageInfo);
	System.out.println(pageInfo.getList());
	map.put("pageInfo", pageInfo);
	m.addAttribute("pageInfo", pageInfo);
	return "examAllot";
}
@RequestMapping("/allotexam")
public String allotExam(Integer examId,Integer[] userId,Model m,HttpSession session) throws Exception{
	Exam eee=new Exam();
	eee=examService.getById(examId);
	String position=eee.getPosition();
	session.setAttribute("position", position);
	Date st=eee.getStartTime();
	Date et=eee.getEndTime();
	session.setAttribute("st", st);
	session.setAttribute("et", et);
	String n1=eee.getName();
	session.setAttribute("n1", n1);
	
	StringBuilder sb=new StringBuilder();
	String result = "";
   List<User> uu=new ArrayList<User>();
    List<UserExamKey> list = new ArrayList<UserExamKey>();
    for (int i = 0; i < userId.length; i++ ) {
    	UserExamKey uek = new UserExamKey();
        uek.setUserId(userId[i]);
        uek.setExamId(examId);
        list.add(uek);
        examService.allotExam(uek);
        Exam ex=new Exam();
        ex.setId(examId);
        examService.changeState(ex);
        User us=new User(); 
        us=userService.getOneUser(userId[i]);
        us.setId(userId[i]);
//      us.setEn(us.getEn());
        userService.changeEn(us);
        uu.add(us);
        sb.append("<input type='checkbox' name='name' value="+us.getName()+">").append(us.getName());
    }
   m.addAttribute("sb", sb.toString());
   List<String> allname=examService.getAllName(examId);
	session.setAttribute("allname",allname);
	return "message1";
	
}
@RequestMapping("/sendmessage1")
public String sendMess(String[] name,Model m,HttpSession session){
	for(int i=0;i<name.length;i++){
		User u=userService.getUserByName(name[i]);
		int nnnnn=u.getEn();
		JOptionPane.showMessageDialog(null, "发送监考分配短信\n"+name[i]+"老师\n您的监考科目为"+session.getAttribute("n1")+
		"\n考场是"+session.getAttribute("position")+"\n开始时间是"+session.getAttribute("st")+"\n结束时间是"+session.getAttribute("et")+
		"\n本场考试的监考老师有"+session.getAttribute("allname")+"\n你现在已经有的监考数量是"+nnnnn);	
	}
	m.addAttribute("1",1);
	session.setAttribute("2", 2);
	return "index";}
}
