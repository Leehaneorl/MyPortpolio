package com.pettaming;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//기본이 되는 매핑컨트롤러
@Controller
public class MainController {
	
	//기본 매핑
	@GetMapping("/index")
	public String started() {
		
		return "index";
	}

	//Login 화면 매핑
	@GetMapping("/login")
	public String viewLoginPage(Model theModel) {
		
		theModel.addAttribute("pageTitle","로그인");
		
		return "login";
	}
	
}
