package org.dnr.devoir.controller;

import org.dnr.devoir.metier.utilisateur.IUtilisateurMetier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Manage authentification of user
 */
public class CustomAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {
	private IUtilisateurMetier metier;
	
	 @Override
	 public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
	      String userTargetUrl = "/user";
	      String adminTargetUrl = "/admin";
	      Set<String> roles =  AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	    		  
	      if (roles.contains("ROLE_ADMIN")) {
	         getRedirectStrategy().sendRedirect(request, response, adminTargetUrl);
	      } else if (roles.contains("ROLE_USER")) {
	         getRedirectStrategy().sendRedirect(request, response, userTargetUrl);
	      } else {
	         super.onAuthenticationSuccess(request, response, authentication);
	         return;
	      }
	   }
	}
