package com;
import javax.jws.WebService;
@WebService
public interface Login {
	String login(String name,String password);
}