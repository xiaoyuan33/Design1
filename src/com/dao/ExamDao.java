package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Exam;
import com.entity.User;
import com.entity.UserExamKey;


@Repository

public interface ExamDao {
public void addExam(Exam exam);
public List<Map<String,Object>> listExam();
List<User> getUser(User user);
List<Exam> getExam(Exam exam);
public void allotExam(UserExamKey userExamKey);
public List<Map<String,Object>> allotnum();
public void changeState(Exam exam);
public Exam getById(int id);
List<String> getAllName(int examId);
List<Map<String,Object>> getTime();
}
