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
import application.model.Kapcsolat;
import application.model.User;

@Controller
public class KapcsolatController {
	

	@Autowired
	private KapcsolatDAO kapcsolatDAO;
	

	@PostMapping(value = "/velemeny")
	public String addKapcsolat(@RequestParam("velemeny") String velemeny, @RequestParam("ertekeles") int ertekeles, HttpSession session)
	{
		String felhasznalo;
		if(session.getAttribute("loggedin") != null) {
			User user = (User) session.getAttribute("user");
				felhasznalo = user.getUName();
			}else {
				felhasznalo = "";
			}
				
		Kapcsolat kapcsolat = new Kapcsolat(velemeny, ertekeles,felhasznalo);
		kapcsolatDAO.insertKapcsolat(kapcsolat);

		return "redirect:/kosz";
	}
	
	@GetMapping(value = "/kosz")
	public String getKosz() {
		return "kosz.html";
	}
	
	@GetMapping("/kapcsolat")
	public String getKapcsolatok(Model model){
			model.addAttribute("kapcsolatok", kapcsolatDAO.listKapcsolatok());
				return "kapcsolat.html";
	
	}
	
	@PostMapping(value = "/deletevelemeny/{id}")
	public String deleteFutar(@PathVariable("id") int id, HttpSession session, Model model) {
		if(session.getAttribute("loggedin") != null) {
			User user = (User) session.getAttribute("user");
			if(user.getJogosultsag() == true) {
				kapcsolatDAO.deleteKapcsolat(id);
				return "redirect:/kapcsolat";
			}
		}
	 	
		return "redirect:/kapcsolat";
	}


}