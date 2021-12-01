package application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.RendelesDAO;
import application.dao.FuvarDAO;
import application.dao.FutarDAO;
import application.model.Fuvar;
import application.model.User;
import application.model.Rendeles;
import application.model.Futar;

import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;


@Controller
public class FuvarController {

    @Autowired
    private FuvarDAO fuvarDAO;
    @Autowired
    private RendelesDAO rendelesDAO ;
    @Autowired
    private FutarDAO futarDAO;

    @GetMapping("/fuvarok")
    public String getFuvarok(HttpSession session, Model model){
        if(session.getAttribute("loggedin") != null) {
            User user = (User) session.getAttribute("user");
            if(user.getJogosultsag() == true) {
                model.addAttribute("fuvarok", fuvarDAO.listFuvarok());
                return "fuvarok.html";
            }
        }
        return "redirect:/";
    }

    @PostMapping(value = "/addfuvar")
    public String addFuvar(@RequestParam("rendelesid") String rendelesid, @RequestParam("futarid") String futarid) {
        if(rendelesid == "" || futarid == ""){return "badrequest.html";}
        else{Fuvar fuvar = new Fuvar(Integer.parseInt(rendelesid), Integer.parseInt(futarid));
        try {
            fuvarDAO.insertFuvar(fuvar);
        }catch(Exception e){return  "badrequest.html";}
        return "redirect:/fuvarok";}
    }

    @PostMapping(value = "/deletefuvar/{id}")
    public String deleteFuvar(@PathVariable("id") int id) {
        fuvarDAO.deleteFuvar(id);

        return "redirect:/fuvarok";
    }

    @GetMapping(value = "/editfuvar/{id}")
    public String editFuvar(@PathVariable("id") int id, Model model) {
        Fuvar fuvar = fuvarDAO.getFuvarById(id);
        model.addAttribute("fuvar", fuvar);

        return "update-fuvar";
    }

    @PostMapping(value = "/updatefuvar/{id}")
    public String updateFuvar(@PathVariable("id") int id, @RequestParam("rendelesid") String rendelesid, @RequestParam("futarid") String futarid) {
        try {
            if(rendelesid == "" || futarid == ""){return "badrequest.html";}
            fuvarDAO.updateFuvar(id, Integer.parseInt(rendelesid), Integer.parseInt(futarid));
        }catch(Exception e){return  "badrequest.html";}


        return "redirect:/fuvarok";
    }
    
    @PostMapping(value = "/fuvarkiosztas")
    public String fuvarkiosztas() {
    	List<Rendeles> rendelesek = new ArrayList<Rendeles>();
    	rendelesek = rendelesDAO.getRendelesek();
    	
    	List<Futar> futarok = new ArrayList<Futar>();
    	
    	List<Fuvar> fuvarok = new ArrayList<Fuvar>();
    	fuvarok = fuvarDAO.listFuvarok();
    	
    	
    	for(Rendeles r : rendelesek) {
    		boolean azonos = false;
        	for(Fuvar fuvar : fuvarok) {
        		if(fuvar.getRendelesid() == r.getId()) {
        			azonos = true;
        			break;
        		}
        	}
        	if(!azonos) {
        		futarok = futarDAO.listFutarok();
        		int futarid = 0;
            	for(Futar f : futarok) {
            		if(f.isElerheto() == true) {
            			futarid = f.getId();
            			futarDAO.updateFutar(futarid,f.getName(), f.getAlkalmazott_miota(), false);
            			break;
            		}
            	}
        		            		
        		Fuvar fuvar = new Fuvar(r.getId(),futarid);
        		fuvarDAO.insertFuvar(fuvar);
        	}
        	
    	}
    	
    	 return "index.html";
    }
    

}