package project.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.domain.Faculty;
import project.domain.User;
import project.service.FacultyService;
import project.service.UserService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private UserService userService;

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
	public ModelAndView registrationFaculty() {
		ModelAndView map = new ModelAndView("registrationFaculty");
		map.addObject("faculties", facultyService.readAll());

		return map;
	}

	@RequestMapping(value = "/joinFaculty", method = RequestMethod.POST)
	public String joinFaculty(@RequestParam String facultyId) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findByEmail(email);

		Faculty faculty = facultyService.findById(Integer.parseInt(facultyId));

		user.setFaculty(faculty);
		Set<User> users = faculty.getUsers();
		users.add(user);

		facultyService.save(faculty);

		return "redirect:/marks";
	}

}
