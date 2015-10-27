package be.g00glen00b.controller;

import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.g00glen00b.entities.UserEntity;
import be.g00glen00b.service.DAOService;

@Controller
public class MainController {
	
	@Autowired
	private DAOService service;

	@RequestMapping(value = "/index.html", method=RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/index.html", method=RequestMethod.POST)
	public String postIndex(@ModelAttribute("userAttribute") UserEntity user, ModelMap model) {
		try {
			service.persistUser(user);
			model.addAttribute("msg", "Gebruiker is succesvol aangemaakt");
		} catch (ConstraintViolationException e) {
			String error = "U hebt bepaalde gegevens niet correct ingevoerd.";
			Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
			if (iterator.hasNext()) {
				String template = iterator.next().getMessageTemplate();
				if ("{javax.validation.constraints.Size.message}".equals(template)) {
					error = "Gelieve alle velden in te vullen";
				} else if ("{javax.validation.constraints.NotNull.message}".equals(template)) {
					error = "Gelieve alle velden in te vullen";
				} else if ("{be.g00glen00b.validation.Email}".equals(template)) {
					error = "Gelieve een geldig mail adres in te voeren";
				}
			}
			model.addAttribute("error", error);
		}
		return "index";
	}
	
	 @ModelAttribute("userAttribute")
	 public UserEntity getUserObject() {
	  return new UserEntity();
	 }
}
