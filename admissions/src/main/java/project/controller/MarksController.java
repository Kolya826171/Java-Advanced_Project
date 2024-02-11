package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.domain.Marks;
import project.domain.User;
import project.service.MarksDTOHelper;
import project.service.MarksService;
import project.service.UserService;

@Controller
public class MarksController {

	@Autowired
	private MarksService marksService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/marks", method = RequestMethod.GET)
	public String enterMarks(Model model) {
		model.addAttribute("marksForm", new Marks());
		
		return "marks";
	}
	
	@RequestMapping(value = "/marks", method = RequestMethod.POST)
	public String enterMarks(@ModelAttribute("userForm") Marks marks, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "marks";
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findByEmail(email);
		user.setMarks(marks);
		
		userService.save(user, user.getPassword());
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/usersMarks", method = RequestMethod.GET)
	public ModelAndView usersMarks() {
		ModelAndView map = new ModelAndView("usersMarks");
		map.addObject("users", MarksDTOHelper.createList(userService.findWithMarks()));

		return map;
	}
	
	
}
