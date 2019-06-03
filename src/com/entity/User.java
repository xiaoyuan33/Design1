package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String name;
	private String password;
	private String level;
	private String introduction;
	private String tel;
	private String authority;
	@ManyToMany
	@JoinTable(name="USER_EXAM",
	joinColumns=@JoinColumn(name="USER_ID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="EXAM_ID",referencedColumnName="ID"))
	private Set<Exam> exams;
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private Set<ReplyTaskResult> replyTaskResults;
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private Set<FileTaskResult> fileTaskResults;
	private int en;
	public int getEn() {
		return en;
	}
	public void setEn(int en) {
		this.en = en;
	}
	public int getId() {
		return id;
	}
	public Set<Exam> getExams() {
		return exams;
	}
	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getLevel() {
		return level;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getTel() {
		return tel;
	}
	public String getAuthority() {
		return authority;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Set<ReplyTaskResult> getReplyTaskResults() {
		return replyTaskResults;
	}
	public Set<FileTaskResult> getFileTaskResults() {
		return fileTaskResults;
	}
	public void setReplyTaskResults(Set<ReplyTaskResult> replyTaskResults) {
		this.replyTaskResults = replyTaskResults;
	}
	public void setFileTaskResults(Set<FileTaskResult> fileTaskResults) {
		this.fileTaskResults = fileTaskResults;
	}
}