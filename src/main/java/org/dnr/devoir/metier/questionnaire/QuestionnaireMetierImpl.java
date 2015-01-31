package org.dnr.devoir.metier.questionnaire;

import java.util.Collection;

import org.dnr.devoir.dao.questionnaire.IQuestionnaireDAO;
import org.dnr.devoir.dao.utilisateur.IUtilisateurDAO;
import org.dnr.devoir.entities.Questionnaire;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class QuestionnaireMetierImpl implements IQuestionnaireMetier {

	private IQuestionnaireDAO dao;
	
	public void setDao(IQuestionnaireDAO dao){
		this.dao = dao;
	}
	
	@Override
	public Questionnaire create(Questionnaire q) throws Exception {
		// TODO Auto-generated method stub
		return dao.create(q);
	}

	@Override
	public Collection<Questionnaire> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAll();
	}

	@Override
	public Collection<String> retrieveAllName() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAllName();
	}

	@Override
	public Questionnaire retrieve(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieve(name);
	}
	
	@Override
	public Questionnaire retrieveId(Integer questionnaireId) throws Exception {
		return dao.retrieveId(questionnaireId);
	}

	@Override
	public boolean exists(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.exists(name);
	}

	@Override
	public Questionnaire update(Questionnaire q) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(q);
	}

	@Override
	public Questionnaire delete(Questionnaire q) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(q);
	}

}
