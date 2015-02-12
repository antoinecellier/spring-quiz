package org.dnr.devoir.metier.utilisateur;

import java.util.Collection;

import org.dnr.devoir.dao.utilisateur.IUtilisateurDAO;
import org.dnr.devoir.entities.Utilisateur;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UtilisateurMetierImpl implements IUtilisateurMetier{
	
	private IUtilisateurDAO dao;
	
	public void setDao(IUtilisateurDAO dao){
		this.dao = dao;
	}
	
	@Override
	public Utilisateur create(Utilisateur u) throws Exception {
		// TODO Auto-generated method stub
		return dao.create(u);
	}

	@Override
	public Collection<Utilisateur> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAll();
	}

	@Override
	public Collection<String> retrieveAllName() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAllName();
	}

	@Override
	public Utilisateur retrieve(String username) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieve(username);
	}

	@Override
	public Utilisateur retrieveId(Integer utilisateurId) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveId(utilisateurId);
	}
	
	@Override
	public boolean exists(String username) throws Exception {
		// TODO Auto-generated method stub
		return dao.exists(username);
	}

	@Override
	public Utilisateur update(Utilisateur u) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(u);
		
	}

	@Override
	public Utilisateur delete(Utilisateur u) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(u);
	}

}
