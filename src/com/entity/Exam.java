package com.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String position;
	private String state;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	private int num;
	@ManyToMany
	@JoinTable(name="USER_EXAM",
			joinColumns=@JoinColumn(name="EXAM_ID",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="USER_ID",referencedColumnName="ID"))
	private Set<User> users;
	public int getId() {
		return id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public String getState() {
		return state;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public int getNum() {
		return num;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setNum(int num) {
		this.num = num;
	}
}