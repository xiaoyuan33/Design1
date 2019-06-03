package com.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.entity.MyMD5Util;
import com.entity.User;

@Controller
public class UserHandler {
	@Autowired
	UserDao userDao;
	@Autowired
	UserService userService;
	@ResponseBody
	@RequestMapping(value = "/getalluser/{id}", produces = "text/html;charset=UTF-8")
	public String getAllUser(@PathVariable("id") Integer id) {
		String str = userService.getAllUser(id);
		return str;
	}
	
	@RequestMapping("adduser")
	public String addUser(User user, Model m) {
		try {
			user.setPassword(MyMD5Util.getEncryptedPwd(user.getPassword()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.addUser(user);
		m.addAttribute("user", user);
		return "addsuccess";
	}
	
	@RequestMapping(value = "changeuser")
	public String changeUser(User user, ModelAndView q) {
		try {
			user.setPassword(MyMD5Util.getEncryptedPwd(user.getPassword()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.changeUser(user);
		return "index";
	}

	@RequestMapping("/listuser/{page}")
	public String getAll(Map<String, Object> map, @PathVariable("page") int page, HttpSession session) {
		PageHelper.startPage(page, 3);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(userService.listUser());
		map.put("pageInfo", pageInfo);
		System.out.println("用户名是" + session.getAttribute("name"));
		System.out.println("密码是" + session.getAttribute("password"));
		return "userlist";
	}
}
