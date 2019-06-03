package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Exam;
import com.entity.UserExamKey;


public interface ExamService {
	public Exam addExam(Exam exam);
	public List<Map<String, Object>> listExam();
	public String getUser(Integer id);
	public String getExam(Integer id);
	public UserExamKey allotExam(UserExamKey ue);
	public List<Map<String, Object>> getUserNum();
	public Exam changeState(Exam exam);
	public Exam getById(int id);
	public List<String> getAllName(int id);
}
