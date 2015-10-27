package be.g00glen00b.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import be.g00glen00b.domain.User;
import be.g00glen00b.service.DAOService;

@Controller
public class MainController {

	@Autowired
	private Mapper mapper;

	@Autowired
	private DAOService service;

	@RequestMapping(value = "/index.html")
	public String getIndex(ModelMap model) {
		model.addAttribute("user", mapper.map(service.getUser(1), User.class));
		return "index";
	}
}