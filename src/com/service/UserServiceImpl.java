package com.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.MyMD5Util;
import com.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User login(String name, String password) {
		User user = new User();
		user = userDao.selectByLogin(name);
		if(user!=null) {
			try {
				if (MyMD5Util.validPassword(password, user.getPassword())) {
					return user;
				}
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return null;
	}

	@Override
	public User addUser(User user) {
		userDao.addUser(user);
		return user;
	}

	@Override
	public String getAllUser(Integer id) {
		User e = new User();

		List<User> list = userDao.getAllUser(e);

		StringBuilder sb = new StringBuilder();
		for (User s : list) {
			if (s.getId() == (id)) {
				sb.append("<option value=" + s.getName() + " selected>").append(s.getName()).append("</option>");
			} else {
				sb.append("<option value=" + s.getName() + ">").append(s.getName()).append("</option>");
			}
		}
		return sb.toString();
	}

	@Override
	public User changeUser(User user) {
		userDao.changeUser(user);

		return user;
	}

	@Override
	public List<Map<String, Object>> listUser() {
		// TODO Auto-generated method stub
		return userDao.listUser();
	}

	@Override
	public User changeEn(User user) {
		userDao.changeEn(user);
		return null;
	}

	@Override
	public User getOneUser(Integer id) {
		userDao.getOneUser(id);
		return userDao.getOneUser(id);
	}

	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);

	}

}
