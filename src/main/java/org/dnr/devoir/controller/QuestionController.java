package org.dnr.devoir.controller;

import org.dnr.devoir.entities.Question;
import org.dnr.devoir.entities.Reponse;
import org.dnr.devoir.metier.question.IQuestionMetier;
import org.dnr.devoir.model.QuestionForm;
import org.dnr.devoir.model.ReponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {
	@Autowired
	private IQuestionMetier metier;

    @Autowired
    ServletContext context;

    @Autowired
	ResourceLoader resourceLoader;

    /**
     * show all question
     * @throws Exception
     */
	@RequestMapping(value="admin/question")
	public String index(Model model) throws Exception{
		model.addAttribute("questionForm", new QuestionForm());
		
		List<Question> questions = (List<Question>) metier.retrieveAll();
		model.addAttribute("listQuestion", questions);

		return "admin/question/index";
	}

    /**
     * Add question
     * @throws Exception
     */
	@RequestMapping(value="admin/ajouterQuestion")
	public String ajouter(QuestionForm qf,Model model) throws Exception{
		Question q = new Question(qf.getName());
		if(q != null)
			metier.create(q);

		return "redirect:/admin/question";
	}

    /**
     * Show a question
     * @param questionId question id
     * @throws Exception
     */
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

    /**
     * Add a response text
     * @throws Exception
     */
	@RequestMapping(value="admin/ajouterReponse")
	public String ajouterRep(Model model, ReponseForm rf,
							 RedirectAttributes redirectAttrs) throws Exception{
		Integer questionId = rf.getQuestionId();
		Question q = metier.retrieveId(questionId);
		
		Reponse rep = metier.createReponse(new Reponse(rf.getName(), "text", q, rf.getCorrect()));

		redirectAttrs.addAttribute("questionId", questionId);
		return "redirect:/admin/showQuestion/{questionId}";
	}

    /**
     * Add a response text
     * @throws Exception
     */
	@RequestMapping(value="admin/ajouterReponseImage", method = RequestMethod.POST)
	public String ajouterRepImage(Model model, ReponseForm rf, HttpServletRequest request,
								  RedirectAttributes redirectAttrs) throws Exception{
		
		Integer questionId = rf.getQuestionId();
		Question q = metier.retrieveId(questionId);
		MultipartFile file = rf.getFileUpload();


		 if (!file.isEmpty() && file.getSize() > 100000)
		     throw new RuntimeException("File too large");
		 
		 Date currentDate = new Date();
		 
		 String fileName = currentDate.getTime()+"-"+file.getOriginalFilename();



		// File finalFile = resourceLoader.getResource("resources/images/"+fileName).getFile();
         File path = new File(this.context.getInitParameter("data")+fileName);
		 try{
			 file.transferTo(path);
			 Reponse rep = metier.createReponse(new Reponse(fileName, "image", q, rf.getCorrect()));
			 
		 } catch (IllegalStateException e) {
	            e.printStackTrace();
	            return "File uploaded failed:" + e.getMessage();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "File uploaded failed:" + e.getMessage();
	        }
		redirectAttrs.addAttribute("questionId", questionId);
		return "redirect:/admin/showQuestion/{questionId}";
	}

    /**
     * delete response
     * @throws Exception
     */
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

    @RequestMapping(value="user/image/{imageNom}.{extension}")
    public void showImage(@PathVariable String imageNom,@PathVariable String extension, HttpServletResponse res) throws IOException {

        File path = new File(this.context.getInitParameter("data")+imageNom+"."+extension);

        String mimetype = this.context.getMimeType(path.toString());
        res.setContentType(mimetype);
        BufferedInputStream read = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());

        byte[] buffer = new byte[8192];

        int longueur = 0;

        while ( ( longueur = read.read( buffer ) ) > 0 ) {
            out.write( buffer, 0, longueur );
        }
        read.close();
        out.close();
    }

    /**
     * delete response picture
     * @throws Exception
     */
	@RequestMapping(value="admin/deleteReponseImage/{reponseId}/{questionId}")
	public String deleteReponseImage(@PathVariable Integer reponseId,@PathVariable Integer questionId,
					   Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) throws Exception{
		
		Reponse r = metier.retrieveIdReponse(reponseId);
		Question q = metier.retrieveId(questionId);

        File finalFile = new File(this.context.getInitParameter("data")+r.getName());

		if(r != null){
			if(finalFile.delete()){
				q.getReponses().remove(r);
				metier.deleteReponse(r);
			}

		}
			
		
		redirectAttrs.addAttribute("questionId", questionId);
		return "redirect:/admin/showQuestion/{questionId}";
	}

    /**
     * delete question
     * @throws Exception
     */
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
