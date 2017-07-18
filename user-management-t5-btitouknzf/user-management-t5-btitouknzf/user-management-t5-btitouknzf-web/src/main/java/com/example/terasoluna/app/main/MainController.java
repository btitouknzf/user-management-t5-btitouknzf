package com.example.terasoluna.app.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("top")
public class MainController {
	
	@RequestMapping(value = "menu", method = RequestMethod.GET, params = "home")
	public String mainmenu(SessionStatus sessionStatus){
		return "top/menu";
	}

}
