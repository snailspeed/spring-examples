package be.g00glen00b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.g00glen00b.domain.Text;

@Controller
public class FormController {

	@RequestMapping(value = "/form.html", method = RequestMethod.POST)
	public String postFormBean(@ModelAttribute("tekst") Text tekst,
			BindingResult result, ModelMap model) {
		model.addAttribute("tekst", tekst.getTekst());
		return "result";
	}

	@RequestMapping(value = "/form.html", method = RequestMethod.GET)
	public ModelAndView getFormBean() {
		return new ModelAndView("form", "command", new Text());
	}

	@RequestMapping(value = "/form2.html", method = RequestMethod.POST)
	public String postFormEasy(@RequestParam("tekst") String text,
			ModelMap model) {
		model.addAttribute("tekst", text);
		return "result";
	}

	@RequestMapping(value = "/form2.html", method = RequestMethod.GET)
	public String getFormEasy() {
		return "form2";
	}
}
