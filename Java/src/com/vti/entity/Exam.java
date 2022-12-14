package com.vti.entity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Exam {
	private int id;
	private String code;
	private String title;
	private String category;
	private Question[] questions;
	private int duration;
	List<Account> accounts;
	private LocalDateTime createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Question[] getQuestions() {
		return questions;
	}

	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Exam(int id, String code, String title, String category, Question[] questions, int duration,
			List<Account> accounts, LocalDateTime createDate) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.category = category;
		this.questions = questions;
		this.duration = duration;
		this.accounts = accounts;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", code=" + code + ", title=" + title + ", category=" + category + ", questions="
				+ Arrays.toString(questions) + ", duration=" + duration + ", accounts=" + accounts + ", createDate="
				+ createDate + "]";
	}

}
