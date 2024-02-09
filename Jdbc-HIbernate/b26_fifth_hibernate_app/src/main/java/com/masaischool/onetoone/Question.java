package com.masaischool.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String question;
	
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
	Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String question, Answer answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}