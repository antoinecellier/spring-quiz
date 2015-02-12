package org.dnr.devoir.dao.utilisateur;

import java.util.Collection;

import org.dnr.devoir.entities.Utilisateur;

public interface IUtilisateurDAO {
	
	public Utilisateur create (Utilisateur u) throws Exception;

    public Collection<Utilisateur> retrieveAll () throws Exception;

    public Collection<String> retrieveAllName () throws Exception;

    public Utilisateur retrieve (String username) throws Exception;
    
    public Utilisateur retrieveId (Integer utilisateurId) throws Exception;
    
    public boolean exists (String username) throws Exception;

    public Utilisateur update (Utilisateur u) throws Exception;
    
    public Utilisateur delete (Utilisateur u) throws Exception;
	
}
