package application.controller;

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

import application.dao.DogDAO;
import application.dao.RegDAO;
import application.model.Kosar;
import application.model.User;

@Controller
public class RegController {
	@Autowired
	private RegDAO regDAO;
	
	
	  @GetMapping("/bejelentkezes")
	  public String getBejelentkezes(){
	    return "bejelentkezes.html";
	  }
	  @GetMapping("/regisztracio")
	  public String getRegisztracio(){
		  return "regisztracio.html";
	  }
	  
	  @GetMapping("/kijelentkezes")
	  public String getKijelentkezes(HttpSession session) {
		  if(session.getAttribute("loggedin") != null) { 
			  return "kijelentkezes.html";
		  }
		  return "redirect:/bejelentkezes";
	  }
	  
	@GetMapping("/regisztracio/{hiba}")
	public String getRegisztracio(@PathVariable("hiba") int hiba, Model model) {
		if(hiba == 1) {
			model.addAttribute("hiba", "HIBA: Nem megegyező jelszavak");
		}
		else if(hiba == 2) {
			model.addAttribute("hiba", "HIBA: Túl hosszú felhasználónév és/vagy jelszó");
		}
		else if(hiba == 3) {
			model.addAttribute("hiba", "HIBA: Túl rövid felhasználónév/jelszó");
		}
		else if(hiba == 4){
			model.addAttribute("hiba", "HIBA: Felhasználónév már létezik");
		}
		else {
			model.addAttribute("hiba", "Sikeres regisztráció!");
		}
		
		return "regisztracio.html";
	}
	
	@PostMapping(value = "/regisztracio")
	public String registerUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("uname") String uname, @RequestParam("passwd") String passwd,
			@RequestParam("passwd-repeat") String passwdRepeat) {
		
		if(!passwd.equals(passwdRepeat)) {
			return "redirect:/regisztracio/1";
		}
		else if(uname.length() > 16 || passwd.length() > 24) {
			return "redirect:/regisztracio/2";
		}
		else if(uname.length() < 6 || passwd.length() < 8) {
			return "redirect:/regisztracio/3";
		}
		
		if(regDAO.insertUser(new User(name, uname, passwd, email, false))) {
			return "redirect:/regisztracio/0";
		}
		else {
			return "redirect:/regisztracio/4";
		}
	}
	
	@GetMapping(value = "/bejelentkezes/{hiba}")
	public String getBejelentkezes(@PathVariable("hiba") String hiba, Model model) {
		model.addAttribute("hiba", "1");
		return "bejelentkezes.html";
	}
	
	@PostMapping(value = "/bejelentkezes")
	public String loginUser(@RequestParam("uname") String uname, @RequestParam("passwd") String password,
			HttpSession session, HttpServletResponse response) {
		if(regDAO.credsCorrect(uname, password)) {
			session.setAttribute("loggedin", true);
			User user = regDAO.getUserFromUName(uname);

			session.setAttribute("user", user);
			session.setAttribute("kosar", new Kosar());
			
			String val = "1";
			if(user.getJogosultsag() == true) {
				val = "2";
			}
			Cookie cookie = new Cookie("bejelentkezve", val);
			cookie.setPath("/");
			response.addCookie(cookie);
			return "redirect:/";
		}
		else {
			return "redirect:/bejelentkezes/1";
		}
	}
	
	@PostMapping(value = "/kijelentkezes")
		public String logOut(HttpSession session, HttpServletResponse response) {
			session.invalidate();
			
			Cookie cookie = new Cookie("bejelentkezve", null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			return "redirect:/";
	}
}
