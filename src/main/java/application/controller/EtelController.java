package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.EtelDAO;
import application.model.Etel;

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
	public String getPizzak(Model model) {
		model.addAttribute("etelek", etelDAO.listPizzak());
		return "pizzak.html";
	} 
	
	
	

	@GetMapping("/etelek")
	public String listEtel(Model model) {
		model.addAttribute("etelek", etelDAO.listEtelek());

		return "index";
	}

	 @PostMapping(value = "/addetel")
	public String addEtel(@RequestParam("nev") String nev, @RequestParam("ar") int ar) {
		Etel etel = new Etel(nev, ar);
		etelDAO.insertEtel(etel);

		return "index";
	}
	 
	 
	 @PostMapping(value = "/addpizza")
		public String addPizza(@RequestParam("nev") String nev, @RequestParam("ar") int ar) {
			Etel etel = new Etel(nev, ar);
			etelDAO.insertEtel(etel);

			return "pizzak.html";
		}
	 
	 

	@PostMapping(value = "/deleteetel/{nev}")
	public String deleteEtel(@PathVariable("nev") String nev) {
		etelDAO.deleteEtel(nev);
	
		return "index";
	}

	@GetMapping(value = "/editetel/{nev}")
	public String editEtel(@PathVariable("nev") String nev, Model model) {
		Etel etel = etelDAO.getEtelByNev(nev);
		model.addAttribute("etel", etel);

		return "update-etel";
	}

	@PostMapping(value = "/updateetel/{nev}")
	public String updateEtel(@PathVariable("nev") String nev, @RequestParam("ar") int ar) {
		etelDAO.updateEtel(nev, ar);

		return "index";
	} 
}
