package application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.FutarDAO;
import application.model.Futar;
import application.model.User;

@Controller
public class FutarController {

	@Autowired
	private FutarDAO futarDAO;

	@GetMapping("/futarok")
	public String getFutarok(HttpSession session, Model model){
		if(session.getAttribute("loggedin") != null) {
			User user = (User) session.getAttribute("user");
			if(user.getJogosultsag() == true) {
				model.addAttribute("futarok", futarDAO.listFutarok());
				return "futarok.html";
			}
		}
		return "redirect:/";
	}

	@PostMapping(value = "/addfutar")
	public String addFutar(@RequestParam("name") String name, @RequestParam("alkalmazott_miota") int alkalmazott_miota) {
		Futar futar = new Futar(name, alkalmazott_miota);
		futarDAO.insertFutar(futar);

		return "redirect:/";
	}

	@PostMapping(value = "/deletefutar/{id}")
	public String deleteFutar(@PathVariable("id") int id) {
	 	futarDAO.deleteFutar(id);
	
		return "redirect:/";
	}

	@GetMapping(value = "/editfutar/{id}")
	public String editFutar(@PathVariable("id") int id, Model model) {
		Futar futar = futarDAO.getFutarById(id);
		model.addAttribute("futar", futar);

		return "update-futar";
	}

	@PostMapping(value = "/updatefutar/{id}")
	public String updateFutar(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("alkalmazott_miota") int alkalmazott_miota) {
		futarDAO.updateFutar(id, name, alkalmazott_miota);

		return "redirect:/";
	}

}