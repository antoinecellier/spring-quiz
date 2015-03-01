package org.dnr.devoir.metier.utilisateur;

import org.dnr.devoir.entities.Utilisateur;

import java.util.Collection;

public interface IUtilisateurMetier{
	
	public Utilisateur create (Utilisateur u) throws Exception;

    public Collection<Utilisateur> retrieveAll () throws Exception;

    public Collection<String> retrieveAllName () throws Exception;

    public Collection<Utilisateur> retrieveBestScore () throws Exception;

    public Utilisateur retrieve (String name) throws Exception;

    public Utilisateur retrieveId (Integer utilisateurId) throws Exception;
    
    public boolean exists (String name) throws Exception;

    public Utilisateur update (Utilisateur u) throws Exception;
    
    public Utilisateur delete (Utilisateur u) throws Exception;

}
