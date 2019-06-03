package com.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dao.ReplyTaskDao;
import com.dao.ReplyTaskResultDao;
import com.entity.ReplyTask;
import com.entity.ReplyTaskResult;
import com.entity.User;
@Controller
@Validated
public class ReplyTaskController {
	@Autowired
	ReplyTaskDao replyTaskDao;
	@Autowired
	ReplyTaskResultDao replyTaskResultDao;
	@PostMapping("/addreply")
	public String addReplyTask(ReplyTask replyTask,String deadlinn) {
		deadlinn=deadlinn.replace("T", " ");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date deadline=null;
		try {
			deadline = format.parse(deadlinn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		replyTask.setDeadline(deadline);
		replyTaskDao.addReplyTask(replyTask);
		JOptionPane.showMessageDialog(null, "任务添加成功！");  
		return "page";
	}
	
	@GetMapping("/queryreply")
	public String queryReplyTask(HttpSession session) {
		List<ReplyTask> replyTasks=replyTaskDao.QueryReplyTask();
		session.setAttribute("replyTasks", replyTasks);
		User user=(User) session.getAttribute("user");
		List<ReplyTaskResult> replyTaskResults=replyTaskResultDao.QueryRepliedTask(user);
		List<ReplyTask> repliedTasks=new ArrayList<>();
		List<ReplyTask> replyTasks1=new ArrayList<>();
		int m=replyTasks.size();
		int n=replyTaskResults.size();
		for (int i = 0; i < m; i++) {
			int flag=0;
			for (int j = 0; j < n; j++) {
				if(replyTasks.get(i).getId()==replyTaskResults.get(j).getReplyTask().getId()) {
					flag=1;
				}
			}
			if(flag==1) {
				repliedTasks.add(replyTasks.get(i));
			}else {
				replyTasks1.add(replyTasks.get(i));
			}
		}
		session.setAttribute("unReplyTasks", replyTasks1);
		session.setAttribute("repliedTasks", repliedTasks);
		return "page-list";
	}
	
	@GetMapping("/queryone/{id}")
	public String getReplyTask(@PathVariable int id,HttpSession session) {
		
		ReplyTask replyTask=replyTaskDao.QueryReplyTaskById(id);
		session.setAttribute("currentReplyTask", replyTask);
		return "page-out";
	}
	
	@GetMapping("/queryone1/{id}")
	public String getRepliedTask(@PathVariable int id,HttpSession session) {
		ReplyTask replyTask=replyTaskDao.QueryReplyTaskById(id);
		session.setAttribute("currentReplyTask", replyTask);
		User user=(User) session.getAttribute("user");
		ReplyTaskResult replyTaskResult=replyTaskResultDao.QueryReplied(user, replyTask);
		session.setAttribute("currentRepliedTask", replyTaskResult);
		if(replyTaskResult.isOnTime())
			session.setAttribute("ontime", "按时提交");
		else {
			session.setAttribute("ontime", "未按时提交");
		}
		return "page-watch";
	}
	
	@PostMapping("/addreplyresult")
	public  String addReplyTaskResult(ReplyTaskResult replyTaskResult,HttpSession session) {
		ReplyTask replyTask=(ReplyTask) session.getAttribute("currentReplyTask");
		User user=(User) session.getAttribute("user");
		replyTaskResult.setReplyTask(replyTask);
		replyTaskResult.setUser(user);
		Date date=new Date();
		if(date.after(replyTask.getDeadline())) {
			replyTaskResult.setOnTime(false);
			JOptionPane.showMessageDialog(null, "超时完成！");  
			session.setAttribute("ontime", "否");
		}else {
			replyTaskResult.setOnTime(true);
			session.setAttribute("ontime", "是");
		}
		replyTaskResultDao.addReplyTaskResult(replyTaskResult);
		session.setAttribute("currentRepliedTask", replyTaskResult);
		return "page-watch";
	}
}