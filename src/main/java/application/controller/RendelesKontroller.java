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
	
	@GetMapping("/rendelesek")
	public String getRendelesek(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user == null || !user.getJogosultsag()) {
			return "redirect:/";
		}
		
		List<Rendeles> rendelesek = rendelesDao.getRendelesek();
		model.addAttribute("rendelesek", rendelesek);
		return "rendelesek.html";
	}
	
	@GetMapping("/deleterendeles/{id}")
	public String deleteRendeles(@PathVariable("id") int id, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user == null || !user.getJogosultsag()) {
			return "redirect:/";
		}

		rendelesDao.deleteRendeles(String.valueOf(id));
		
		return "redirect:/rendelesek";
	}
	
	
	@GetMapping("/rendeleseim")
	public String getRendeleseim(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return "redirect:/";
		}
		
		List<Rendeles> rendelesek = rendelesDao.getRendelesForUser(user);
		model.addAttribute("rendelesek", rendelesek);
		
		return "rendeleseim.html";
	}
	
}
