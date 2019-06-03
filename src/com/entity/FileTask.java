package com.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FileTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String introduction;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	private boolean isClose;
	@OneToMany(mappedBy="fileTask",cascade=CascadeType.REMOVE)
	private Set<FileTaskResult> fileTaskResults;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public Date getDeadline() {
		return deadline;
	}
	public boolean isClose() {
		return isClose;
	}
	public Set<FileTaskResult> getFileTaskResults() {
		return fileTaskResults;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}
	public void setFileTaskResults(Set<FileTaskResult> fileTaskResults) {
		this.fileTaskResults = fileTaskResults;
	}
}
