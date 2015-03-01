package org.dnr.devoir.dao.questionnaire;

import org.dnr.devoir.entities.Questionnaire;

import java.util.Collection;


public interface IQuestionnaireDAO {

    /**
     * insert a questionnaire
     * @param q Instance of questionnaire
     * @throws Exception
     */
	public Questionnaire create (Questionnaire q) throws Exception;

    /**
     * Retrieve all questionnaire
     * @throws Exception
     */
    public Collection<Questionnaire> retrieveAll () throws Exception;

    public Collection<String> retrieveAllName () throws Exception;

    /**
     * Retrieve a questionnaire by id
     * @param questionnaireId questionnaire id
     * @throws Exception
     */
    public Questionnaire retrieveId (Integer questionnaireId) throws Exception;


    public Questionnaire retrieve (String name) throws Exception;

    public boolean exists (String name) throws Exception;

    /**
     * Delete a questionnaire
     * @param q questionnaire
     * @return
     * @throws Exception
     */
    public Questionnaire update (Questionnaire q) throws Exception;

    /**
     * Update a questionnaire
     * @param q questionnaire
     * @return
     * @throws Exception
     */
    public Questionnaire delete (Questionnaire q) throws Exception;
    
}
