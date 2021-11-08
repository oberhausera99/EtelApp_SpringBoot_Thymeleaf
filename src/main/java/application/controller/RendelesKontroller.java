package application.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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

import application.dao.RegDAO;
import application.dao.RendelesDAO;
import application.model.Rendeles;
import application.model.User;


@Controller
public class RendelesKontroller {
	@Autowired
	private RegDAO regDao;
	
	@Autowired
	private RendelesDAO rendelesDao;
	
	@GetMapping("/rendeleseim")
	public String getRendeleseim(Model model, HttpSession session) {
		Rendeles rendeles = new Rendeles();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return "redirect:/";
		}
		
		List<Rendeles> rendelesek = rendelesDao.getRendelesForUser(user);
		model.addAttribute("rendelesek", rendelesek);
		
		return "rendeleseim.html";
	}
	
}
