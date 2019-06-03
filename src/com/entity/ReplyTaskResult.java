package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ReplyTaskResult {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String replyInfo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable=false,updatable=false,
	columnDefinition="DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date finishTime;
	private boolean isOnTime;
	@ManyToOne
	private ReplyTask replyTask;
	@ManyToOne
	private User user;
	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getReplyInfo() {
		return replyInfo;
	}
	public boolean isOnTime() {
		return isOnTime;
	}
	public void setOnTime(boolean isOnTime) {
		this.isOnTime = isOnTime;
	}
	public ReplyTask getReplyTask() {
		return replyTask;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setReplyInfo(String replyInfo) {
		this.replyInfo = replyInfo;
	}
	public void setReplyTask(ReplyTask replyTask) {
		this.replyTask = replyTask;
	}
}
