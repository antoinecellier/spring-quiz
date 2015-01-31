package org.dnr.devoir.metier.question;

import java.util.Collection;
import java.util.List;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Reponse;

public interface IQuestionMetier{

	public Question create (Question q) throws Exception;

    public List<Question> retrieveAll () throws Exception;

    public Collection<String> retrieveAllName () throws Exception;

    public Question retrieve (String name) throws Exception;
    
    public Question retrieveId (Integer questionId) throws Exception;

    public boolean exists (String name) throws Exception;

    public Question update (Question q) throws Exception;
    
    public Question delete (Question q) throws Exception;
    
    // "C" operations

    /**
     * Adds an answer to this database.
     * @param name Name of answer
    */

    public Reponse createReponse (Reponse r);

    // "R" operations

    /**
     * Returns the list of all answers in this database.
     * @return The list of all answers in this database as an instance of java.util.Collection<Question>.
     * @throws Exception if a database access error occurs
     */
    public Collection<Reponse> retrieveAllReponse () throws Exception;

    /**
     * Returns the list of all name's answers (i.e., primary keys) in this database.
     * @return The list of all name's answers in this database as an instance of java.util.Collection<String>.
     * @throws Exception if a database access error occurs
     */
    public Collection<String> retrieveAllNameReponse () throws Exception;

    /**
     * Returns the answer with a given name (i.e., primary key).
     * @param name The name to search for
     * @return The answer with the given name in the list
     * @throws Exception if no answer with the given name exists in the list or a database access error
     * occurs
     */
    public Reponse retrieveReponse (String name) throws Exception;

    /**
     * Returns the answer with a given id (i.e., primary key).
     * @param id The id to search for
     * @return The answer with the given id in the list
     * @throws Exception if no answer with the given name exists in the list or a database access error
     * occurs
     */
    public Reponse retrieveIdReponse (Integer reponseId) throws Exception;
    
    
    /**
     * Decides whether a answer with a given name exists in the list.
     * @return true is the list contains a answer with the given name,
     * false otherwise
     * @throws Exception if a database access error occurs
     */
    public boolean existsReponse (String name) throws Exception;

    // "U" operations

    /**
     * Updates the answer associated to a given name in the database.
     * Given that the email address is part of an instance of Person, this method
     * may be safely used to change the email address itself.
     * @param name The name of the answer to update
     * @param question An instance of Answer to store in place of the existing one
     * @throws Exception if no question is currently associated to the given name,
     * or the new instance has an email address which already exists in the database, or a
     * database access error occurs
     */
    public Reponse updateReponse (Reponse r) throws Exception;
    

    /**
     * Removes the answer with a given name from this database.
     * @param name The name of the answer to remove
     * @throws Exception if no question is currently associated to the given name
     * or a database access error occurs
     */
    public Reponse deleteReponse (Reponse r) throws Exception;
    
}
