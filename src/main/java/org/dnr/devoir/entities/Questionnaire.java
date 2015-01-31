package org.dnr.devoir.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Questionnaires")
public class Questionnaire implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTIONNAIRE_ID", unique = true, nullable = false)
	private Integer questionnaireId;
	private String name;

	@ManyToMany
	@JoinTable(name = "questionnaire_question", joinColumns = 
	@JoinColumn(name = "QUESTIONNAIRE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "QUESTION_ID"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Question> questions;
	
	public Questionnaire() {
		super();
	}
	
	public Questionnaire(String name) {
		super();
		this.name = name;
	}
	
	public Questionnaire(String name, Collection<Question> questions) {
		super();
		this.name = name;
		this.questions = questions;
	}

	public Integer getQuestionnaireId() {
		return this.questionnaireId;
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
