package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.User;


@Repository
public interface UserDao {
public User selectByLogin(String name);
public void addUser(User user);
List<User> getAllUser(User user);
public void changeUser(User user);
public List<Map<String,Object>> listUser();
public List<Map<String,Object>> listUserDesc();
public void changeEn(User user);
public User getOneUser(int id);
public User getUserByName(String name);
}
