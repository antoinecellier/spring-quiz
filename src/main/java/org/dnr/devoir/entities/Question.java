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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Questions")
public class Question implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID", unique = true, nullable = false)
	private Integer questionId;
	private String name;
	@ManyToMany(mappedBy="questions")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Questionnaire> questionnaires;
	
	@OneToMany(mappedBy="question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Collection<Reponse> reponses;

	
	public Question() {
		super();
	}
	
	public Question(String name) {
		super();
		this.name = name;
	}
	
	public Question(String name, Collection<Reponse> reponses) {
		super();
		this.name = name;
		this.reponses = reponses;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}
 
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Collection<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	public Collection<Reponse> getReponses() {
		return reponses;
	}
	
	public void setReponses(Collection<Reponse> reponses) {
		this.reponses = reponses;
	}
	
}
