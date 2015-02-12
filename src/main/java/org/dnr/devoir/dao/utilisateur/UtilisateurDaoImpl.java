package org.dnr.devoir.dao.utilisateur;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dnr.devoir.entities.Utilisateur;

public class UtilisateurDaoImpl implements IUtilisateurDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Utilisateur create(Utilisateur u) throws Exception {
		em.persist(u);
		return u;
	}

	@Override
	public List<Utilisateur> retrieveAll() throws Exception {
		Query req = em.createQuery("select u from Utilisateur u");
		return req.getResultList();
	}

	@Override
	public List<String> retrieveAllName() throws Exception {
		Query req = em.createQuery("select u.username from Utilisateur u");
		return req.getResultList();
	}

	@Override
	public Utilisateur retrieve(String username) throws Exception {
		Query q = em.createQuery("select u from Utilisateur u where u.username=:username")
				    .setParameter("username", username);
		Utilisateur u = (Utilisateur) q.getSingleResult();
		if (u == null) throw new RuntimeException("Utilisateur introuvable");
		return u;
	}

	@Override
	public Utilisateur retrieveId(Integer utilisateurId) throws Exception {
		Utilisateur u = em.find(Utilisateur.class, utilisateurId);
		if (u == null) throw new RuntimeException("Utilisateur introuvable");
		return u;
	}
	
	@Override
	public boolean exists(String username) throws Exception {
		Utilisateur u = em.find(Utilisateur.class, username);
		if (u == null) return false;
		return true;
	}

	@Override
	public Utilisateur update(Utilisateur u) throws Exception {
		em.merge(u);
		return u;
	}

	@Override
	public Utilisateur delete(Utilisateur u) throws Exception {
		em.remove(em.merge(u));
		return u;
	}

}
