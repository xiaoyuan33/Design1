package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExamDao;
@Service
public class TimeServiceImpl implements TimeService {
@Autowired
ExamDao examDao;
	public List<Map<String, Object>> getTime() {
		
		return examDao.getTime();
	}

}
