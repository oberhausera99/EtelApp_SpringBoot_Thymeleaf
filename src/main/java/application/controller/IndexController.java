package application.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import application.model.User;

@Controller
public class IndexController {
	
	  @GetMapping("/")
	  public String get(HttpSession session) {
			if(session.getAttribute("loggedin") != null) {
				User user = (User) session.getAttribute("user");
				if(user != null && user.getJogosultsag() == true) {
					return "redirect:/futarok";
				}
			}
			return "redirect:/index";
	  }
	
	  @GetMapping("/index")
	  public String getIndex(HttpSession session){
	    return "index.html";
	 }
	  



	  
}
