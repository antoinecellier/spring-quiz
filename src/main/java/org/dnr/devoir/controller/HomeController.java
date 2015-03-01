package org.dnr.devoir.controller;

import org.dnr.devoir.entities.Utilisateur;
import org.dnr.devoir.metier.utilisateur.IUtilisateurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Home controller
 */
@Controller
public class HomeController {
    @Autowired
    private IUtilisateurMetier metierUtilisateur;

    /**
     * Home
     * @throws Exception
     */
	@RequestMapping(value="/")
	public String index(Model model) throws Exception{
        List<Utilisateur> utilisateurs = (List<Utilisateur>) metierUtilisateur.retrieveBestScore();
        model.addAttribute("listUtilisateur", utilisateurs);
		return "home";
	}

    /**
     * Home admin
     * @throws Exception
     */
	@RequestMapping(value="/admin")
	public String indexAdmin() throws Exception{
		return "admin/home";
	}
}
