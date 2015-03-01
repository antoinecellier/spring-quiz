package org.dnr.devoir.controller;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Questionnaire;
import org.dnr.devoir.entities.Reponse;
import org.dnr.devoir.entities.Utilisateur;
import org.dnr.devoir.metier.question.IQuestionMetier;
import org.dnr.devoir.metier.questionnaire.IQuestionnaireMetier;
import org.dnr.devoir.metier.utilisateur.IUtilisateurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
public class JeuController {

	@Autowired
	private IQuestionnaireMetier metierQuestionnaire;
	
	@Autowired
	private IQuestionMetier metierQuestion;

	@Autowired
	private IUtilisateurMetier metierUtilisateur;
	
	@RequestMapping(value="user")
	public String indexUser(Model model) throws Exception{
		
		List<Questionnaire> questionnaires = (List<Questionnaire>) metierQuestionnaire.retrieveAll();
		model.addAttribute("listQuestionnaire", questionnaires);

        List<Utilisateur> utilisateurs = (List<Utilisateur>) metierUtilisateur.retrieveBestScore();
        model.addAttribute("listUtilisateur", utilisateurs);
		return "user/home";
	}
	
	@RequestMapping(value="user/startQuestionnaire/{questionnaireId}")
	public String startQuestionnaire(@PathVariable Integer questionnaireId,Model model) throws Exception{
		
		Questionnaire q = metierQuestionnaire.retrieveId(questionnaireId);
		List<Question> questionsCurrentQuestionnaire = (List<Question>) q.getQuestions();
		List<Question> copyQuestions = new ArrayList<Question>(questionsCurrentQuestionnaire);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName();
		Utilisateur currentUser = metierUtilisateur.retrieve(userName);
		List<Question> questionsUserCorrect = (List<Question>) currentUser.getCorrectQuestions();
		
		for(Question questQuestionnaire : questionsCurrentQuestionnaire){
			for(Question questCorrectUser : questionsUserCorrect){
				if(questQuestionnaire.getQuestionId().equals(questCorrectUser.getQuestionId())){
					copyQuestions.remove(questQuestionnaire);
				}
			}
		}
		
		model.addAttribute("questionnaire", q);
		model.addAttribute("questions", copyQuestions);
		
		return "user/startQuestionnaire";
	}

	
	@RequestMapping(value="user/checkQuestionnaire/{questionnaireId}", method = RequestMethod.POST)
	public String checkQuestionnaire(@PathVariable Integer questionnaireId,
									 HttpServletRequest request,Model model) throws Exception{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName();
		Utilisateur currentUser = metierUtilisateur.retrieve(userName);
		
		Questionnaire q = metierQuestionnaire.retrieveId(questionnaireId);
		
		Enumeration<String> params = request.getParameterNames();
		
		Boolean result = false;
		
		Integer score = 0;
		Integer correctReponse = 0;
		
		while(params.hasMoreElements()){
			
			String param = params.nextElement();
			if(!param.equals("_csrf")){
				String[] parts = param.split("-");
				String part1 = parts[0]; // type 
				Integer idQuestion = Integer.parseInt(parts[1]); // question
				Question currentQuestion = metierQuestion.retrieveId(idQuestion);
				
				if(part1.equals("c")){
					result = this.handleResultCheckBox(request.getParameterValues(param),currentQuestion);
				}else{
					result = this.handleResultRadio(request.getParameter(param),currentQuestion);
				}
				
				if(result){
					score ++;
					correctReponse ++;
					List<Question> correctQuestionUser = (List<Question>) currentUser.getCorrectQuestions();
					correctQuestionUser.add(currentQuestion);
					currentUser.setCorrectQuestions(correctQuestionUser);
					currentUser.setScore(score + currentUser.getScore());
					metierUtilisateur.update(currentUser);
				}
				else{
					score = score - 1;
                    currentUser.setScore(score + currentUser.getScore());
                    metierUtilisateur.update(currentUser);
				}
			}
		}
		
		model.addAttribute("score", score);
		model.addAttribute("correctReponse", correctReponse);
		
		model.addAttribute("questionnaire", metierQuestionnaire.retrieveId(questionnaireId));
		
		return "user/resultQuestionnaire";
	}
	
	@RequestMapping(value="user/score")
	public String score(Model model) throws Exception{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName();
		Utilisateur currentUser = metierUtilisateur.retrieve(userName);
		
		model.addAttribute("score", currentUser.getScore());
		return "user/score";
	}
	
	public Boolean handleResultCheckBox(String[] values,Question q) throws NumberFormatException, Exception{
		
		Boolean flag = true;
		
		for(String value : values){
			Reponse rep = metierQuestion.retrieveIdReponse(Integer.parseInt(value));
			flag = flag && rep.getCorrect();
		}
		return flag;
	}


	public Boolean handleResultRadio(String value, Question q) throws NumberFormatException, Exception{
		Reponse rep = metierQuestion.retrieveIdReponse(Integer.parseInt(value));
		
		return rep.getCorrect();
	}
	
}
