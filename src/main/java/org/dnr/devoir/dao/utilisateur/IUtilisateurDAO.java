package org.dnr.devoir.dao.utilisateur;

import org.dnr.devoir.entities.Utilisateur;

import java.util.Collection;

public interface IUtilisateurDAO {

    /**
     * insert a new user
     * @param u instance of user
     * @throws Exception
     */
	public Utilisateur create (Utilisateur u) throws Exception;

    /**
     * Retrieve all user
     * @return
     * @throws Exception
     */
    public Collection<Utilisateur> retrieveAll () throws Exception;

    /**
     * Retrieve user with best score
     * @return
     * @throws Exception
     */
    public Collection<Utilisateur> retrieveBestScore () throws Exception;

    /**
     * Retrieve all name of user
     * @return
     * @throws Exception
     */
    public Collection<String> retrieveAllName () throws Exception;

    /**
     * Retrieve user by name
     * @param username user's name
     * @return
     * @throws Exception
     */
    public Utilisateur retrieve (String username) throws Exception;

    /**
     * Retrieve user by id
     * @param utilisateurId user'id
     * @return
     * @throws Exception
     */
    public Utilisateur retrieveId (Integer utilisateurId) throws Exception;

    /**
     * Check if user exists
     * @param username
     * @return
     * @throws Exception
     */
    public boolean exists (String username) throws Exception;

    /**
     * Update user
     * @param u instance of Utilisateur
     * @return
     * @throws Exception
     */
    public Utilisateur update (Utilisateur u) throws Exception;

    /**
     * Delete user
     * @param u instance of Utilisateur
     * @return
     * @throws Exception
     */
    public Utilisateur delete (Utilisateur u) throws Exception;
	
}
