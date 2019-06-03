package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FileTaskResult {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishTime;
	private String fileInfo;
	private boolean isOnTime;
	@ManyToOne
	private FileTask fileTask;
	@ManyToOne
	private User user;
	public int getId() {
		return id;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public String getFileInfo() {
		return fileInfo;
	}
	public boolean isOnTime() {
		return isOnTime;
	}
	public FileTask getFileTask() {
		return fileTask;
	}
	public User getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}
	public void setOnTime(boolean isOnTime) {
		this.isOnTime = isOnTime;
	}
	public void setFileTask(FileTask fileTask) {
		this.fileTask = fileTask;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
