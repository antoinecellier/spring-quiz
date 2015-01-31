package org.dnr.devoir.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reponses")
public class Reponse implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPONSE_ID", unique = true, nullable = false)
	private Integer reponseId;
	private String name;
	private String type;
	private Boolean correct;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	
	public Reponse() {
		super();
	}

	public Reponse(String name, String type, Question question, Boolean correct) {
		super();
		this.name = name;
		this.type = type;
		this.correct = correct;
		this.question = question;
	}

	public Reponse(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public Integer getReponseId() {
		return this.reponseId;
	}
 
	public void setReponseId(Integer reponseId) {
		this.reponseId = reponseId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	
}
