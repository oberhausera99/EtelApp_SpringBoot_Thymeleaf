package application.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

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

import application.model.Etel;
import application.model.Kosar;
import application.model.User;
import application.dao.EtelDAO;
import application.dao.KosarDAO;

@Controller
public class KosarController {
	@Autowired
	EtelDAO etelDao;
	@Autowired
	KosarDAO kosarDao;
	
	@GetMapping(value = "/kosartorol/{nev}")
	public String getKosartorol(@PathVariable("nev") String nev, HttpSession session) {
		Kosar kosar = ((Kosar)session.getAttribute("kosar"));
		Etel etel = etelDao.getEtelByNev(nev);
		kosar.deleteEtel(etel);
		
		return "redirect:/kosar";
	}
	
	@GetMapping(value = "/megrendel")
	public String getMegrendel(HttpSession session) {
		Kosar kosar = ((Kosar)session.getAttribute("kosar"));
		User user = ((User)session.getAttribute("user"));
		
		for(Entry<Etel, Integer> entry : kosar.getEtelek().entrySet()) {
			kosarDao.rendelesRogzit(user, entry.getKey());
		}
		
		kosar.getEtelek().clear();
		return "sikeresrendeles.html";
	}
		
	@GetMapping(value = "/kosar")
	public String getKosar(HttpSession session, Model model) {
		Kosar kosar = ((Kosar)session.getAttribute("kosar"));
		model.addAttribute("kosar", kosar.getEtelek());
		
		return "kosar.html";
	}
	
	@GetMapping(value = "/updatekosar/{nev}")
	public String updateKosar(@PathVariable("nev") String nev, HttpSession session, Model model) {
		Kosar kosar = ((Kosar)session.getAttribute("kosar"));
		Etel etel = etelDao.getEtelByNev(nev);
		SimpleEntry<Etel, Integer> etelEntry = new SimpleEntry(etel, kosar.getEtelek().get(etel));
				
		model.addAttribute("etel", etelEntry);
		
		return "update-kosar.html";
	}
	
	@PostMapping(value = "/updatekosar/{nev}")
	public String updateKosar(@PathVariable("nev") String nev, @RequestParam("db") int db, HttpSession session) {
		Etel etel = etelDao.getEtelByNev(nev);
		((Kosar)session.getAttribute("kosar")).modositEtel(etel, db);
		return "redirect:/kosar";
	}
	
	@GetMapping(value = "/kosarbarak/{nev}")
	public String kosarHozzaad(@PathVariable("nev") String nev, HttpSession session) {
		Etel etel = etelDao.getEtelByNev(nev);
		
		((Kosar)session.getAttribute("kosar")).addEtel(etel);
				
		return "redirect:/rendeles";
	}
}
