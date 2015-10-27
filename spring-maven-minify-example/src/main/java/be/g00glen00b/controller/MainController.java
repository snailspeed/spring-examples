package be.g00glen00b.controller;

import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import be.g00glen00b.domain.User;

@Controller
public class MainController {

	@RequestMapping(value = "/index.html")
	public String getIndex(ModelMap model) {
		model.addAttribute("user", new User("Gates", "Bill",
				new GregorianCalendar(1955, 9, 28), true));
		return "index";
	}
}