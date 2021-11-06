package application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.KapcsolatDAO;
import application.model.Futar;
import application.model.Kapcsolat;
import application.model.User;

@Controller
public class KapcsolatController {

	@Autowired
	private KapcsolatDAO kapcsolatDAO;

	@PostMapping(value = "/velemeny")
	public String addKapcsolat(@RequestParam("velemeny") String velemeny, @RequestParam("ertekeles") int ertekeles) {
		Kapcsolat kapcsolat = new Kapcsolat(velemeny, ertekeles);
		kapcsolatDAO.insertKapcsolat(kapcsolat);

		return "redirect:/kosz";
	}
	
	@GetMapping(value = "/kosz")
	public String getKosz() {
		return "kosz.html";
	}

}