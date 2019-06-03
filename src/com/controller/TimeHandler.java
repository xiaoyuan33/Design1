package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.TimeService;

//@Controller
@Component("task")
public class TimeHandler {
	@Autowired
	TimeService service;
	 @Scheduled(cron = "0/10 12 23 * * ?")
	 public void taskCycle(){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //显示的格式
		 String date = sdf.format(new Date());
		 List<Map<String,Object>> list=new ArrayList<Map<String,Object>>(service.getTime());
		 for (Map<String, Object> map : list) {
          String name=(String) map.get("un");
          String ename=(String) map.get("en");
          String position=(String) map.get("position");
			 Date startTime=(Date) map.get("startTime");
			 //System.out.println("考试开始时间为"+startTime);
			 String st=sdf.format(startTime);
			 int day1=Integer.parseInt(date.substring(8,10));
			 int day2=Integer.parseInt(st.substring(8,10));
			 int day3=day2-day1;
			 System.out.println(map);
			 System.out.println(day1);
			 System.out.println(day2);
			 System.out.println(day3);
			 if(day3==1){ System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");   
			 System.out.println("亲爱的"+name);
			 System.out.println("考试开始时间为"+startTime);
			 System.out.println("考试科目为"+ename);
			 System.out.println("地点为"+position);
			 System.out.println("准备好去监考吧!");
			 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); }
	        }
	 }
}
