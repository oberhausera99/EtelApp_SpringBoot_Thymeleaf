package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.FuvarDAO;
import application.model.Fuvar;


@Controller
public class FuvarController {

    @Autowired
    private FuvarDAO fuvarDAO;

    @GetMapping(value = "/fuvarok")
    public String listFuvar(Model model) {
        model.addAttribute("fuvars", fuvarDAO.listFuvars());

        return "index";
    }

    @PostMapping(value = "/addfuvar")
    public String addFuvar(@RequestParam("rendelesid") int rendelesid, @RequestParam("futarid") int futarid) {
        Fuvar fuvar = new Fuvar(rendelesid, futarid);
        fuvarDAO.insertFuvar(fuvar);

        return "fuvar";
    }

    @PostMapping(value = "/deletefuvar/{id}")
    public String deleteFuvar(@PathVariable("id") int id) {
        fuvarDAO.deleteFuvar(id);

        return "fuvar";
    }

    @GetMapping(value = "/editfuvar/{id}")
    public String editFuvar(@PathVariable("id") int id, Model model) {
        Fuvar fuvar = fuvarDAO.getFuvarById(id);
        model.addAttribute("fuvar", fuvar);

        return "update-fuvar";
    }

    @PostMapping(value = "/updatefuvar/{id}")
    public String updateFuvar(@PathVariable("id") int id, @RequestParam("rendelesid") int rendelesid, @RequestParam("futarid") int futarid) {
        fuvarDAO.updateFuvar(id, rendelesid, futarid);

        return "fuvar";
    }

}