package org.dnr.devoir.model;

import java.util.Collection;

import org.dnr.devoir.entities.Question;

public class QuestionnaireForm {

	private Integer questionnaireId;
	private String name;
	private Collection<Question> questions;
	
	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
	
}
