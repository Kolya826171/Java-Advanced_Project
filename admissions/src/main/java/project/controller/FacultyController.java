package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.domain.Faculty;
import project.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/createFaculty", method = RequestMethod.GET)
	public ModelAndView createFaculty() {
		return new ModelAndView("createFaculty", "facultyForm", new Faculty());
	}

	@RequestMapping(value = "/createFaculty", method = RequestMethod.POST)
	public String createFaculty(@ModelAttribute("facultyForm") Faculty faculty, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "createFaculty";
		}

		facultyService.save(faculty);

		return "redirect:/home";
	}
	
	@RequestMapping(value = "/registrationFaculty", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView map = new ModelAndView("registrationFaculty");
		map.addObject("faculties", facultyService.readAll());
		
		return map;
	}

	
	
}
