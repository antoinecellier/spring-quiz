package org.dnr.devoir.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Questionnaire;
import org.dnr.devoir.metier.question.IQuestionMetier;
import org.dnr.devoir.metier.questionnaire.IQuestionnaireMetier;
import org.dnr.devoir.model.QuestionForm;
import org.dnr.devoir.model.QuestionnaireForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireMetier metier;
	@Autowired
	private IQuestionMetier metierQuestion;
	
	@RequestMapping(value="admin/questionnaire")
	public String index(Model model) throws Exception{
		model.addAttribute("questionnaireForm", new QuestionnaireForm());
		
		List<Questionnaire> questionnaires = (List<Questionnaire>) metier.retrieveAll();
		model.addAttribute("listQuestionnaire", questionnaires);

		return "admin/questionnaire/index";
	}
	
	@RequestMapping(value="admin/ajouterQuestionnaire")
	public String ajouter(QuestionnaireForm qf,Model model) throws Exception{
		Questionnaire q = new Questionnaire(qf.getName());
		if(q != null)
			metier.create(q);

		return "redirect:/admin/questionnaire";
	}

	@RequestMapping(value="admin/showQuestionnaire/{questionnaireId}")
	public String show(@PathVariable Integer questionnaireId,
					   Model model) throws Exception{
		Questionnaire q = metier.retrieveId(questionnaireId);
		model.addAttribute("Questionnaire", q);
		model.addAttribute("listQuestion", q.getQuestions());
		model.addAttribute("questionForm", new QuestionForm());
		try{
			List<Question> questionsDispo = (List<Question>) metierQuestion.retrieveAll();	
			if(questionsDispo  != null){
				Map<Integer,String> questionSelect = new HashMap<Integer,String>();
				for (Question quest : questionsDispo ) questionSelect.put(quest.getQuestionId(),quest.getName());			
				model.addAttribute("questionSelect", questionSelect);
			}
		}catch(Exception e){
			throw new Exception(e);
		}
		
		return "admin/questionnaire/show";
	}
	
	@RequestMapping(value="admin/ajouterQuestionQuestionnaire/{questionnaireId}")
	public String ajouterAuQuestionnaire(QuestionForm qf,Model model,RedirectAttributes redirectAttrs,
										 @PathVariable Integer questionnaireId) throws Exception{
		Question q = metierQuestion.retrieveId(qf.getQuestionId());
		Questionnaire qre = metier.retrieveId(questionnaireId);
		qre.getQuestions().add(q);
		
		metier.update(qre);

		redirectAttrs.addAttribute("questionnaireId", questionnaireId);
		return "redirect:/admin/showQuestionnaire/{questionnaireId}";
	}

	@RequestMapping(value="admin/supprimerQuestionQuestionnaire/{questionId}/{questionnaireId}")
	public String supprimerDuQuestionnaire(Model model,RedirectAttributes redirectAttrs,
										   @PathVariable Integer questionnaireId,
										   @PathVariable Integer questionId) throws Exception{
		Question q = metierQuestion.retrieveId(questionId);
		Questionnaire qre = metier.retrieveId(questionnaireId);
		qre.getQuestions().remove(q);
		
		metier.update(qre);

		redirectAttrs.addAttribute("questionnaireId", questionnaireId);
		return "redirect:/admin/showQuestionnaire/{questionnaireId}";
	}
	
	@RequestMapping(value="admin/deleteQuestionnaire/{questionnaireId}")
	public String delete(@PathVariable Integer questionnaireId,
					   Model model) throws Exception{
		Questionnaire q = metier.retrieveId(questionnaireId);
		
		if(q != null)
			metier.delete(q);
		
		return "redirect:/admin/questionnaire";
	}

}
