package application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import application.dao.DogDAO;
import application.dao.RegDAO;
import application.model.User;

@Controller
public class RegController {
	@Autowired
	private RegDAO regDAO;
	
	@PostMapping(value = "/regisztracio")
	public String registerUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("uname") String uname, @RequestParam("passwd") String passwd,
			@RequestParam("passwd-repeat") String passwdRepeat) {
		
		if(regDAO.insertUser(new User(name, uname, passwd, email, false))) {
			return "redirect:/";
		}
		else {
			return "redirect:/404";
		}
	}
	
	@PostMapping(value = "/bejelentkezes")
	public String loginUser(@RequestParam("uname") String uname, @RequestParam("passwd") String password,
			HttpSession session) {
		if(regDAO.credsCorrect(uname, password)) {
			session.setAttribute("loggedin", true);
			User user = regDAO.getUserFromUName(uname);

			session.setAttribute("user", user);
			return "redirect:/";
		}
		else {
			return "redirect:/404";
		}
	}
	
	@PostMapping(value = "/kijelentkezes")
		public String logOut(HttpSession session) {
			session.invalidate();
			return "redirect:/";
	}
}
