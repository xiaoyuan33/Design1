package com;
import javax.jws.WebService;
@WebService
public interface wsInterface {
	String login(String name,String password);
	void roomReseve();
	String viewInfo(String name);
	void ticketReseve();
	void viewReseve();
}
