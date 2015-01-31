package org.dnr.devoir.dao.questionnaire;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dnr.devoir.entities.Questionnaire;

public class QuestionnaireDaoImpl implements IQuestionnaireDAO{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Questionnaire create(Questionnaire q) throws Exception {
		// TODO Auto-generated method stub
		em.persist(q);
		return q;
		
	}

	@Override
	public Collection<Questionnaire> retrieveAll() throws Exception {
		Query req = em.createQuery("select q from Questionnaire q");
		return req.getResultList();
	}

	@Override
	public Collection<String> retrieveAllName() throws Exception {
		Query req = em.createQuery("select q.name from Questionnaire q");
		return req.getResultList();
	}

	@Override
	public Questionnaire retrieve(String name) throws Exception {
		Questionnaire q = em.find(Questionnaire.class, name);
		if( q == null ) throw new RuntimeException("Questionnaire introuvable");
		return q;
	}
	
	@Override
	public Questionnaire retrieveId(Integer questionnaireId) throws Exception {
		Questionnaire q = em.find(Questionnaire.class, questionnaireId);
		if( q == null ) throw new RuntimeException("Questionnaire introuvable");
		return q;
	}
	
	@Override
	public boolean exists(String name) throws Exception {
		Questionnaire q = em.find(Questionnaire.class, name);
		if( q == null ) return false;
		return true;
	}

	@Override
	public Questionnaire update(Questionnaire q) throws Exception {
		em.merge(q);
		return q;
	}

	@Override
	public Questionnaire delete(Questionnaire q) throws Exception {
		em.remove(em.merge(q));
		return q;
	}

}
