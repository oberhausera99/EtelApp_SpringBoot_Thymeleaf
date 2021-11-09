package application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.FuvarDAO;
import application.model.Fuvar;
import application.model.User;

@Controller
public class FuvarController {

    @Autowired
    private FuvarDAO fuvarDAO;

    @GetMapping("/fuvarok")
    public String getFuvarok(HttpSession session, Model model){
        if(session.getAttribute("loggedin") != null) {
            User user = (User) session.getAttribute("user");
            if(user.getJogosultsag() == true) {
                model.addAttribute("fuvarok", fuvarDAO.listFuvarok());
                return "fuvar.html";
            }
        }
        return "redirect:/";
    }

    @PostMapping(value = "/addfuvar")
    public String addFuvar(@RequestParam("rendelesid") int rendelesid, @RequestParam("futarid") int futarid) {
        Fuvar fuvar = new Fuvar(rendelesid, futarid);
        fuvarDAO.insertFuvar(fuvar);

        return "redirect:/";
    }

    @PostMapping(value = "/deletefuvar/{id}")
    public String deleteFuvar(@PathVariable("id") int id) {
        fuvarDAO.deleteFuvar(id);

        return "redirect:/";
    }

    @GetMapping(value = "/editfuvar/{id}")
    public String editFuvar(@PathVariable("id") int id, Model model) {
        Fuvar fuvar = fuvarDAO.getFuvarById(id);
        model.addAttribute("fuvar", fuvar);

        return "update-fuvar";
    }

    @PostMapping(value = "/updatefuvar/{id}")
    public String updateFuvar(@RequestParam("rendelesid") int rendelesid, @RequestParam("futarid") int futarid, @PathVariable("id") int id) {
        fuvarDAO.updateFuvar(rendelesid, futarid, id);

        return "redirect:/";
    }

}