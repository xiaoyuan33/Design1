package com.controller;


import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginHandler {
	@Autowired
	UserDao userDao;
	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public String login(String name, String password, Model m, HttpSession session) {
		m.addAttribute("name", name);
		m.addAttribute("password", password);
		User user = userService.login(name, password);
		if (user!= null) {
			session.setAttribute("user", user);
			return "index";
		} else {
			JOptionPane.showMessageDialog(null, "用户名或密码错误", "警告", JOptionPane.WARNING_MESSAGE);
			return "login";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session,SessionStatus sessionStatus) {
		System.out.println(session==null);
		session.invalidate();
		sessionStatus.setComplete();
		System.out.println(session==null);
		return "login";
	}
}
