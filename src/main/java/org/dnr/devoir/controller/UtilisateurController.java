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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UtilisateurController {
	@Autowired
	private IUtilisateurMetier metier;
	
	@RequestMapping(value="admin/utilisateur")
	public String index(Model model) throws Exception{
		model.addAttribute("utilisateurForm", new UtilisateurForm());
		
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrateur");
		roles.put("ROLE_USER", "Utilisateur");
		model.addAttribute("roleSelect", roles);
		
		List<Utilisateur> listUtilisateur = (List<Utilisateur>) metier.retrieveAll();
		model.addAttribute("listUtilisateur", listUtilisateur);
		return "admin/utilisateur/index";
	}

    @RequestMapping(value="/newUser")
    public String newUser(Model model) throws Exception{
        model.addAttribute("utilisateurForm", new UtilisateurForm());

        Map<String, String> roles = new HashMap<String, String>();
        roles.put("ROLE_USER", "Utilisateur");
        model.addAttribute("roleSelect", roles);

        return "newUser";
    }

	@RequestMapping(value={"admin/ajouterUtilisateur", "publicAddUser"})
	public String ajouter(UtilisateurForm uf, Model model, HttpServletRequest request) throws Exception{
		Utilisateur u = new Utilisateur(uf.getUsername(), uf.getPassword(), uf.getRole(), 1);
		Utilisateur uFinal = metier.create(u);

		model.addAttribute("utilisateurForm", uf);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken))
            return "redirect:utilisateur";
        else
            return "redirect:/login";
	}
	
	@RequestMapping(value="admin/deleteUtilisateur/{utilisateurId}")
	public String delete(@PathVariable Integer utilisateurId,
					   Model model, final RedirectAttributes redirectAttributes) throws Exception{
		Utilisateur u = metier.retrieveId(utilisateurId);
		
		UserDetails currentUserDetail =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Utilisateur currentUser = metier.retrieve(currentUserDetail.getUsername());
	      
		if(u != null){
			if( u.getUtilisateurId() == currentUser.getUtilisateurId()){
				 redirectAttributes.addFlashAttribute("messageFlash",
						  "Vous êtes actuellement connecté avec ce compte, impossible de le supprimer");
				 return "redirect:/admin/utilisateur";				
			}else{
				metier.delete(u);
			}
		}
		
		return "redirect:/admin/utilisateur";
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
