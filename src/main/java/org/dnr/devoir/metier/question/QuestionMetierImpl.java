package org.dnr.devoir.metier.question;

import java.util.Collection;
import java.util.List;

import org.dnr.devoir.dao.question.IQuestionDAO;
import org.dnr.devoir.dao.utilisateur.IUtilisateurDAO;
import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Reponse;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class QuestionMetierImpl implements IQuestionMetier{

	private IQuestionDAO dao;
	
	public void setDao(IQuestionDAO dao){
		this.dao = dao;
	}
	
	@Override
	public Question create(Question q) throws Exception {
		// TODO Auto-generated method stub
		return dao.create(q);
	}

	@Override
	public List<Question> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAll();
	}

	@Override
	public Collection<String> retrieveAllName() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAllName();
	}

	@Override
	public Question retrieve(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieve(name);
	}

	@Override
	public boolean exists(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.exists(name);
	}

	@Override
	public Question update(Question q) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(q);
	}

	@Override
	public Question delete(Question q) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(q);
	}

	@Override
	public Question retrieveId(Integer questionId) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveId(questionId);
	}
	
	@Override
	public Reponse createReponse(Reponse r) {
		// TODO Auto-generated method stub
		return dao.createReponse(r);
	}

	@Override
	public Collection<Reponse> retrieveAllReponse() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAllReponse();
	}

	@Override
	public Collection<String> retrieveAllNameReponse() throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveAllName();
	}

	@Override
	public Reponse retrieveReponse(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveReponse(name);
	}

	@Override
	public boolean existsReponse(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.existsReponse(name);
	}

	@Override
	public Reponse updateReponse(Reponse r) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateReponse(r);
	}

	@Override
	public Reponse deleteReponse(Reponse r) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteReponse(r);
	}

	@Override
	public Reponse retrieveIdReponse(Integer reponseId) throws Exception {
		// TODO Auto-generated method stub
		return dao.retrieveIdReponse(reponseId);
	}

}
