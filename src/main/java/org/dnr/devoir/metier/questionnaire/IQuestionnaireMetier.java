package org.dnr.devoir.metier.questionnaire;

import java.util.Collection;

import org.dnr.devoir.entities.Questionnaire;

public interface IQuestionnaireMetier {

	public Questionnaire create (Questionnaire q) throws Exception;

    public Collection<Questionnaire> retrieveAll () throws Exception;

    public Collection<String> retrieveAllName () throws Exception;

    public Questionnaire retrieve (String name) throws Exception;
    
    public Questionnaire retrieveId (Integer questionnaireId) throws Exception;

    public boolean exists (String name) throws Exception;

    public Questionnaire update (Questionnaire q) throws Exception;
    
    public Questionnaire delete (Questionnaire q) throws Exception;
}
