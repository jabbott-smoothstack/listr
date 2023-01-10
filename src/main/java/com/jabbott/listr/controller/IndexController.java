package com.jabbott.listr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String getIndex() {
		return "index";
	}
	
	@GetMapping(value = "api/user/login")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping(value = "listpage/")
	public String getListPage() {
		return "login";
	}
}
