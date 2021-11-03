package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.DogDAO;
import application.model.Dog;


@Controller
public class DogController {

	@Autowired
	private DogDAO dogDAO;

	@GetMapping(value = "/")
	public String listDog(Model model) {
		model.addAttribute("dogs", dogDAO.listDogs());

		return "index";
	}

	@PostMapping(value = "/add")
	public String addDoge(@RequestParam("name") String name, @RequestParam("age") int age) {
		Dog dog = new Dog(name, age);
		dogDAO.insertDog(dog);

		return "redirect:/";
	}

	@PostMapping(value = "/delete/{id}")
	public String deleteDog(@PathVariable("id") int id) {
		dogDAO.deleteDog(id);
	
		return "redirect:/";
	}

	@GetMapping(value = "/edit/{id}")
	public String editDog(@PathVariable("id") int id, Model model) {
		Dog dog = dogDAO.getDogById(id);
		model.addAttribute("dog", dog);

		return "update-dog";
	}

	@PostMapping(value = "/update/{id}")
	public String updateDog(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("age") int age) {
		dogDAO.updateDog(id, name, age);

		return "redirect:/";
	}

}