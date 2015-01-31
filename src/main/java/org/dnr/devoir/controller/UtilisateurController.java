package org.dnr.devoir.controller;

import org.dnr.devoir.entities.Utilisateur;
import org.dnr.devoir.metier.utilisateur.IUtilisateurMetier;
import org.dnr.devoir.model.UtilisateurForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilisateurController {
	@Autowired
	private IUtilisateurMetier metier;
	
	@RequestMapping(value="utilisateur")
	public String index(Model model){
		model.addAttribute("utilisateurForm", new UtilisateurForm());
		return "utilisateur";
	}
	
	@RequestMapping(value="ajouterUtilisateur")
	public String ajouter(UtilisateurForm uf, Model model) throws Exception{
		Utilisateur u = new Utilisateur(uf.getUsername(), uf.getPassword(), "ROLE_ADMIN", 1);
		Utilisateur uFinal = metier.create(u);

		model.addAttribute("utilisateurForm", uf);
		
		return "utilisateur";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }
 
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");
 
	  return model;
	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
 
	  ModelAndView model = new ModelAndView();
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
 
	  model.setViewName("403");
	  return model;
 
	}
}
