package org.dnr.devoir.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Questionnaire;
import org.dnr.devoir.entities.Reponse;
import org.dnr.devoir.metier.question.IQuestionMetier;
import org.dnr.devoir.metier.utilisateur.IUtilisateurMetier;
import org.dnr.devoir.model.QuestionForm;
import org.dnr.devoir.model.QuestionnaireForm;
import org.dnr.devoir.model.ReponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QuestionController {
	@Autowired
	private IQuestionMetier metier;
	
	@RequestMapping(value="admin/question")
	public String index(Model model) throws Exception{
		model.addAttribute("questionForm", new QuestionForm());
		
		List<Question> questions = (List<Question>) metier.retrieveAll();
		model.addAttribute("listQuestion", questions);

		return "admin/question/index";
	}
	
	@RequestMapping(value="admin/ajouterQuestion")
	public String ajouter(QuestionForm qf,Model model) throws Exception{
		Question q = new Question(qf.getName());
		if(q != null)
			metier.create(q);

		return "redirect:/admin/question";
	}
	
	@RequestMapping(value="admin/showQuestion/{questionId}")
	public String show(@PathVariable Integer questionId,
					   Model model) throws Exception{
		Question q = metier.retrieveId(questionId);
		
		// Select : Reponse vrai ou faux
		Map<Boolean, String> correct = new HashMap<Boolean, String>();
		correct.put(false, "FAUX");
		correct.put(true, "VRAI");
		
		
		model.addAttribute("selectCorrect", correct);
		model.addAttribute("Question", q);
		model.addAttribute("listReponses", q.getReponses());
		model.addAttribute("reponseForm", new ReponseForm());

		return "admin/question/show";
	}

	@RequestMapping(value="admin/ajouterReponse")
	public String ajouterRep(Model model, ReponseForm rf,
							 RedirectAttributes redirectAttrs) throws Exception{
		Integer questionId = rf.getQuestionId();
		Question q = metier.retrieveId(questionId);
		
		Reponse rep = metier.createReponse(new Reponse(rf.getName(), "text", q, rf.getCorrect()));

		redirectAttrs.addAttribute("questionId", questionId);
		return "redirect:/admin/showQuestion/{questionId}";
	}

	@RequestMapping(value="admin/ajouterReponseImage")
	public String ajouterRepImage(Model model, ReponseForm rf,
								  RedirectAttributes redirectAttrs, 
								  @RequestParam("name") MultipartFile file) throws Exception{
		Integer questionId = rf.getQuestionId();
		Question q = metier.retrieveId(questionId);
		
		
		//Reponse rep = metier.createReponse(new Reponse(rf.getName(), "text", q, rf.getCorrect()));
		 if (!file.isEmpty() && file.getSize() > 100000)
		     throw new RuntimeException("File too large");
		 
		 model.addAttribute("bytes", file.getBytes());
		 model.addAttribute("contentype",file.getContentType());
		
		redirectAttrs.addAttribute("questionId", questionId);
		return "redirect:/admin/showQuestion/{questionId}";
	}
	
	@RequestMapping(value="admin/deleteReponse/{reponseId}/{questionId}")
	public String deleteReponse(@PathVariable Integer reponseId,@PathVariable Integer questionId,
					   Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) throws Exception{
		
		Reponse r = metier.retrieveIdReponse(reponseId);
		Question q = metier.retrieveId(questionId);
		
		if(r != null){
			q.getReponses().remove(r);
			metier.deleteReponse(r);
		}
			
		
		redirectAttrs.addAttribute("questionId", questionId);
		return "redirect:/admin/showQuestion/{questionId}";
	}
	
	@RequestMapping(value="admin/deleteQuestion/{questionId}")
	public String delete(@PathVariable Integer questionId,
					   Model model, final RedirectAttributes redirectAttributes) throws Exception{
		Question q = metier.retrieveId(questionId);
		
		if(q != null){
			try{
				metier.delete(q);
			}catch(Exception e){
				 redirectAttributes.addFlashAttribute("messageFlash",
						 							  "Cette question appartient à des questionnaires, impossible de la supprimer");
				 return "redirect:/admin/question";
			}
		}
		
		return "redirect:/admin/question";
	}
}
