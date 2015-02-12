package org.dnr.devoir.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Utilisateurs")
public class Utilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTILISATEUR_ID", unique = true, nullable = false)
	private Integer utilisateurId;
	private String username;
	private String password;
	private String role;
	private Integer enabled;
	private Integer score;

	@ManyToMany
	@JoinTable(name = "utilisateur_question", joinColumns = 
	@JoinColumn(name = "UTILISATEUR_ID"), 
	inverseJoinColumns = @JoinColumn(name = "Question_ID"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Question> correctQuestions;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String username, String password, String role, Integer enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.score = 0;
	}
	
	public Integer getUtilisateurId() {
		return this.utilisateurId;
	}
 
	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Collection<Question> getCorrectQuestions() {
		return correctQuestions;
	}

	public void setCorrectQuestions(Collection<Question> correctQuestions) {
		this.correctQuestions = correctQuestions;
	}

	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
