package org.dnr.devoir.dao.questionnaire;

import java.util.Collection;
import java.util.List;

import org.dnr.devoir.entities.Questionnaire;


public interface IQuestionnaireDAO {

	public Questionnaire create (Questionnaire q) throws Exception;

    public Collection<Questionnaire> retrieveAll () throws Exception;

    public Collection<String> retrieveAllName () throws Exception;

    public Questionnaire retrieveId (Integer questionnaireId) throws Exception;
    
    public Questionnaire retrieve (String name) throws Exception;

    public boolean exists (String name) throws Exception;

    public Questionnaire update (Questionnaire q) throws Exception;
    
    public Questionnaire delete (Questionnaire q) throws Exception;
    
}
