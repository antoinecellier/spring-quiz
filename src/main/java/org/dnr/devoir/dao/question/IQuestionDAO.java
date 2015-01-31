package org.dnr.devoir.dao.question;

import java.util.Collection;
import java.util.List;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Reponse;


public interface IQuestionDAO {

    // "C" operations

    /**
     * Adds a question to this database.
     * @param name Name of question
     * @param answers list of responses possible
     * @throws Exception if a question with the same name
    */

    public Question create (Question q) throws Exception;

    // "R" operations

    /**
     * Returns the list of all questions in this database.
     * @return The list of all questions in this database as an instance of java.util.Collection<Question>.
     * @throws Exception if a database access error occurs
     */
    public List<Question> retrieveAll () throws Exception;

    /**
     * Returns the list of all name's question question (i.e., primary keys) in this database.
     * @return The list of all name's question in this database as an instance of java.util.Collection<String>.
     * @throws Exception if a database access error occurs
     */
    public Collection<String> retrieveAllName () throws Exception;

    /**
     * Returns the question with a given name (i.e., primary key).
     * @param name The name to search for
     * @return The question with the given name in the list
     * @throws Exception if no question with the given name exists in the list or a database access error
     * occurs
     */
    public Question retrieve (String name) throws Exception;
    
    /**
     * Returns the question with a given id(i.e., primary key).
     * @param id The id to search for
     * @return The question with the given name in the list
     * @throws Exception if no question with the given name exists in the list or a database access error
     * occurs
     */
    public Question retrieveId (Integer questionId) throws Exception;

    /**
     * Decides whether a question with a given name exists in the list.
     * @return true is the list contains a question with the given name,
     * false otherwise
     * @throws Exception if a database access error occurs
     */
    public boolean exists (String name) throws Exception;

    // "U" operations

    /**
     * Updates the question associated to a given name in the database.
     * Given that the email address is part of an instance of Person, this method
     * may be safely used to change the email address itself.
     * @param name The name of the question to update
     * @param question An instance of Question to store in place of the existing one
     * @throws Exception if no question is currently associated to the given name,
     * or the new instance has an email address which already exists in the database, or a
     * database access error occurs
     */
    public Question update (Question q) throws Exception;
    

    /**
     * Removes the question with a given name address from this database.
     * @param name The name of the question to remove
     * @throws Exception if no question is currently associated to the given name
     * or a database access error occurs
     */
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
