package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExamDao;
import com.dao.UserDao;
import com.entity.*;
@Service
public class ExamServiceImpl implements ExamService {
@Autowired
ExamDao examDao;
@Autowired
UserDao userDao;

	@Override
	public Exam addExam(Exam exam) {
		examDao.addExam(exam);
		return exam;
	}


	public List<Map<String, Object>> listExam() {
		// TODO Auto-generated method stub
		return examDao.listExam();
	}


	@Override
	public String getUser(Integer id) {
		User e=new User();

		List<User> list=examDao.getUser(e);
		
		StringBuilder sb=new StringBuilder();
		for(User s:list){
			if(s.getId()==(id)){
				sb.append("<option value="+s.getId()+" selected>").append(s.getName()).append("</option>");}
			else{
				sb.append("<option value="+s.getId()+">").append(s.getName()).append("</option>");
			}
		}
		return sb.toString();
	}


	@Override
	public String getExam(Integer id) {
		
		Exam e=new Exam();

		List<Exam> list=examDao.getExam(e);
		
		StringBuilder sb=new StringBuilder();
		for(Exam s:list){
			if(s.getId()==(id)){
				sb.append("<option value="+s.getId()+" selected>").append(s.getName()).append("</option>");}
			else{
				sb.append("<option value="+s.getId()+">").append(s.getName()).append("</option>");
			}
		}
		return sb.toString();
	}


	@Override
	public UserExamKey allotExam(UserExamKey ue) {
		examDao.allotExam(ue);
		return ue;
	}


	@Override
	public List<Map<String, Object>> getUserNum() {
		// TODO Auto-generated method stub
		return userDao.listUserDesc();
	}


	@Override
	public Exam changeState(Exam exam) {
		examDao.changeState(exam);
		return exam;
	}


	@Override
	public Exam getById(int id) {
		
		return examDao.getById(id);
	}


	@Override
	public List<String> getAllName(int id) {
		// TODO Auto-generated method stub
		return examDao.getAllName(id);
	}
}
