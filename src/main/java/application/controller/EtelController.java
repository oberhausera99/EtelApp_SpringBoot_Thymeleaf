package application.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.EtelDAO;
import application.model.Etel;
import application.model.User;

@Controller
public class EtelController {

	@Autowired
	private EtelDAO etelDAO;
	
	@GetMapping("/rendeles")
	public String getRendeles(Model model) {
		model.addAttribute("etelek", etelDAO.listEtelek());
		return "rendeles.html";
	}
	
	
	@GetMapping("/pizzak")
	public String getPizzak(Model model, HttpSession session) {
		model.addAttribute("etelek", etelDAO.listPizzak());
		if(session.getAttribute("loggedin") != null) {
			User user = (User) session.getAttribute("user");
			if(user != null && user.getJogosultsag() == true) {
				return "pizzaadmin.html";
			}
		}
		return "pizzak.html";
	}

	
	@GetMapping("/hamburgerek")
	public String getHamburgerek(Model model, HttpSession session) {
		model.addAttribute("etelek", etelDAO.listHamburgerek());
		if(session.getAttribute("loggedin") != null) {
			User user = (User) session.getAttribute("user");
			if(user != null && user.getJogosultsag() == true) {
				return "hamburgeradmin.html";
			}
		}
		return "hamburgerek.html";
	}
	
	@GetMapping("/egyebek")
	public String getEgyebek(Model model, HttpSession session) {
		model.addAttribute("etelek", etelDAO.listEgyebek());
		if(session.getAttribute("loggedin") != null) {
			User user = (User) session.getAttribute("user");
			if(user != null && user.getJogosultsag() == true) {
				return "egyebadmin.html";
			}
		}
		return "egyebek.html";
	}
	
	
	

	/* @GetMapping("/etelek")
	public String listEtel(Model model) {
		model.addAttribute("etelek", etelDAO.listEtelek());

		return "index";
	} */

	 @PostMapping(value = "/addetel")
	public String addEtel(@RequestParam("nev") String nev, @RequestParam("ar") int ar) {
		if(ar <= 0) {
			return "arhiba.html";
		} else if(!(nev.matches(".*[a-zA-Z]+.*"))) {
			return "nevhiba.html";
		} else {
		Etel etel = new Etel(nev, ar);
		etelDAO.insertEtel(etel);

		return "redirect:/index";
		}
	}
	 

	@PostMapping(value = "/deleteetel/{nev}")
	public String deleteEtel(@PathVariable("nev") String nev) {
		etelDAO.deleteEtel(nev);
	
		return "redirect:/index";
		}


	@GetMapping(value = "/editetel/{nev}")
	public String editEtel(@PathVariable("nev") String nev, Model model) {
		 Etel etel = etelDAO.getEtelByNev(nev);
		model.addAttribute("etel", etel); 

		return "update-etel";
	}

	@PostMapping(value = "/updateetel/{nev}")
	public String updateEtel(@PathVariable("nev") String nev, @RequestParam("ar") int ar) {
		if(ar <= 0) {
			return "arhiba.html";
		} else {
		etelDAO.updateEtel(nev, ar);
		return "redirect:/index";
	} 
	}
}
