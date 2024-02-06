package project.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.domain.Faculty;
import project.domain.User;
import project.domain.UserRole;
import project.service.FacultyService;
import project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(user);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		
		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully.");
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView map = new ModelAndView("home");
		map.addObject("users", userService.findByRole(UserRole.ROLE_USER));
		
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

		
		return "redirect:/home";
	}
}
