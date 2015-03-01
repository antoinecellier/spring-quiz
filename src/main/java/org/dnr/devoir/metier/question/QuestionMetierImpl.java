package org.dnr.devoir.metier.question;

import org.dnr.devoir.dao.question.IQuestionDAO;
import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Reponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
public class QuestionMetierImpl implements IQuestionMetier{

	private IQuestionDAO dao;
	
	public void setDao(IQuestionDAO dao){
		this.dao = dao;
	}
	
	@Override
	public Question create(Question q) throws Exception {

		return dao.create(q);
	}

	@Override
	public List<Question> retrieveAll() throws Exception {

		return dao.retrieveAll();
	}

	@Override
	public Collection<String> retrieveAllName() throws Exception {

		return dao.retrieveAllName();
	}

	@Override
	public Question retrieve(String name) throws Exception {

		return dao.retrieve(name);
	}

	@Override
	public boolean exists(String name) throws Exception {

		return dao.exists(name);
	}

	@Override
	public Question update(Question q) throws Exception {

		return dao.update(q);
	}

	@Override
	public Question delete(Question q) throws Exception {

		return dao.delete(q);
	}

	@Override
	public Question retrieveId(Integer questionId) throws Exception {

		return dao.retrieveId(questionId);
	}
	
	@Override
	public Reponse createReponse(Reponse r) {

		return dao.createReponse(r);
	}

	@Override
	public Collection<Reponse> retrieveAllReponse() throws Exception {

		return dao.retrieveAllReponse();
	}

	@Override
	public Collection<String> retrieveAllNameReponse() throws Exception {

		return dao.retrieveAllName();
	}

	@Override
	public Reponse retrieveReponse(String name) throws Exception {

		return dao.retrieveReponse(name);
	}

	@Override
	public boolean existsReponse(String name) throws Exception {

		return dao.existsReponse(name);
	}

	@Override
	public Reponse updateReponse(Reponse r) throws Exception {

		return dao.updateReponse(r);
	}

	@Override
	public Reponse deleteReponse(Reponse r) throws Exception {

		return dao.deleteReponse(r);
	}

	@Override
	public Reponse retrieveIdReponse(Integer reponseId) throws Exception {
		return dao.retrieveIdReponse(reponseId);
	}

}
