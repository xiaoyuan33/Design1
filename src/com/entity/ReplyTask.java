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

import org.springframework.stereotype.Component;

@Entity
@Component
public class ReplyTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String introduction;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	private boolean isClose;
	@OneToMany(mappedBy="replyTask",cascade=CascadeType.REMOVE)
	private Set<ReplyTaskResult> replyTaskResults;
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
	public Set<ReplyTaskResult> getReplyTaskResults() {
		return replyTaskResults;
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
	public boolean isClose() {
		return isClose;
	}
	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}
	public void setReplyTaskResults(Set<ReplyTaskResult> replyTaskResults) {
		this.replyTaskResults = replyTaskResults;
	}
}
