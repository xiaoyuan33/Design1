package com.service;

import java.util.List;
import java.util.Map;

import com.entity.User;
public interface UserService {
public User login(String name,String password);
public User addUser(User user);
public String getAllUser(Integer id);
public User changeUser(User user);
public List<Map<String, Object>> listUser();
public User changeEn(User user);
public User getOneUser(Integer id);
public User getUserByName(String name);
}
