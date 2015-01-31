package org.dnr.devoir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String index() throws Exception{
		return "home";
	}

	@RequestMapping(value="/admin")
	public String indexAdmin() throws Exception{
		return "admin/home";
	}
}
