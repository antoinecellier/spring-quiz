package org.dnr.devoir.dao.question;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Reponse;

public class QuestionDaoImpl implements IQuestionDAO{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Question create(Question q) throws Exception {
		em.persist(q);
		return q;
	}

	@Override
	public List retrieveAll() throws Exception {
		Query q = em.createQuery("select q from Question q");
		return q.getResultList();
	}

	@Override
	public Collection<String> retrieveAllName() throws Exception {
		Query q = em.createQuery("select q.name from Question q");
		return q.getResultList();
	}

	@Override
	public Question retrieve(String name) throws Exception {
		Question q = em.find(Question.class, name);
		if( q == null) throw new RuntimeException("Question introuvable");
		return q;
	}

	@Override
	public boolean exists(String name) throws Exception {
		Question q = em.find(Question.class, name);
		if( q == null) return false;
		
		return true;
	}

	@Override
	public Question update(Question q) throws Exception {
		em.merge(q);
		return q;
	}

	@Override
	public Question delete(Question q) throws Exception {
		em.remove(em.merge(q));
		return q;
	}

	@Override
	public Question retrieveId(Integer questionId) throws Exception {
		Question q = em.find(Question.class, questionId);
		if( q == null) throw new RuntimeException("Question introuvable");
		return q;
	}

	@Override
	public Reponse createReponse(Reponse r) {
		em.persist(r);
		return r;
	}

	@Override
	public Collection<Reponse> retrieveAllReponse() throws Exception {
		Query r = em.createQuery("select r from Reponse r");
		return r.getResultList();
	}

	@Override
	public Collection<String> retrieveAllNameReponse() throws Exception {
		Query r = em.createQuery("select r.name from Reponse r");
		return r.getResultList();
	}

	@Override
	public Reponse retrieveReponse(String name) throws Exception {
		Reponse r = em.find(Reponse.class, name);
		if ( r == null ) throw new RuntimeException("Reponse introuvable");
		return r;
	}

	@Override
	public boolean existsReponse(String name) throws Exception {
		Reponse r = em.find(Reponse.class, name);
		if ( r == null ) return false;
		return true;
	}

	@Override
	public Reponse updateReponse(Reponse r) throws Exception {
		em.merge(r);
		return r;
	}

	@Override
	public Reponse deleteReponse(Reponse r) throws Exception {
		em.remove(em.merge(r));
		return r;
	}

	@Override
	public Reponse retrieveIdReponse(Integer reponseId) throws Exception {
		Reponse r = em.find(Reponse.class, reponseId);
		if ( r == null ) throw new RuntimeException("Reponse introuvable");
		return r;
	}

}
