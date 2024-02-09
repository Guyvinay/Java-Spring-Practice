package com.masaischool.onetoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 2048, nullable = false)
	private String answer;

	@OneToOne
	@JoinColumn(name="question_id")
	Question question;

	public long getId() {
		return id;
	}

	public String getAnswer() {
		return answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
