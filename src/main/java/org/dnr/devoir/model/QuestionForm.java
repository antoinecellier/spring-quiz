package org.dnr.devoir.model;

import java.util.Collection;

import org.dnr.devoir.entities.Reponse;

public class QuestionForm {

	private Integer questionId;
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	private String name;
	private Collection<Reponse> reponses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(Collection<Reponse> reponses) {
		this.reponses = reponses;
	}
	
	
}
