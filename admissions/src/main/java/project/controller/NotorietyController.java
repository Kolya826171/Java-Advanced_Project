package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.domain.Faculty;
import project.domain.Marks;
import project.domain.Notoriety;
import project.domain.NotorietyDTO;
import project.domain.User;
import project.service.FacultyService;
import project.service.MarksService;
import project.service.NotorietyDTOHelper;
import project.service.NotorietyService;
import project.service.UserService;

@Controller
public class NotorietyController {

	@Autowired
	private MarksService marksService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;

	@Autowired
	private NotorietyService notorietyService;

	@RequestMapping(value = "/addToNotoriety", method = RequestMethod.GET)
	public String toNotoriety(@RequestParam String id) throws Exception {
		if (id == null) {
			throw new Exception("id is null in toNotoriety.");
		}
		
		User user = userService.findById(Integer.parseInt(id));

		Marks marks = user.getMarks();
		marksService.save(marks);
		
		Notoriety notoriety = new Notoriety();
		notoriety.setFacultyName(user.getFaculty().getName());
		notoriety.setAveragePoint(marks.getAvgPoint());
		
		user.setNotoriety(notoriety);
		
		userService.save(user, user.getPassword());
		
		return "redirect:/usersMarks";
	}
	
	@RequestMapping(value = "/notoriety", method = RequestMethod.GET)
	public ModelAndView notoriety() {
		
		List<NotorietyDTO> attributeValue = NotorietyDTOHelper.createList(userService.findWithNotoriety());
		return getNotoriety(attributeValue.reversed());
	}
	
	@RequestMapping(value = "/deleteNotoriety", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) throws Exception {
		if (id == null) {
			throw new Exception("id is null in delete.");
		}
		
		User user = userService.findById(Integer.parseInt(id));
		Notoriety notoriety = user.getNotoriety();
		user.setNotoriety(null);
		notorietyService.delete(notoriety);
		
		List<NotorietyDTO> attributeValue = NotorietyDTOHelper.createList(userService.findWithNotoriety());
		return getNotoriety(attributeValue.reversed());
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ModelAndView filter(@RequestParam String facultyName) {	
		if (facultyName.equals("All")) {
			return notoriety();
		}
		
		Faculty faculty = facultyService.findByName(facultyName);
		List<User> users = userService.findByFacultyWithNotoriety(faculty.getId());
	
		List<NotorietyDTO> attributeValue = NotorietyDTOHelper.createList(users).reversed();
		Integer limit = faculty.getNumberOfContractPlaces() + faculty.getNumberOfGovernmentOrders();
		attributeValue = attributeValue.stream().limit(limit).toList();
		
		return getNotoriety(attributeValue);
	}
	
	public ModelAndView getNotoriety(List<NotorietyDTO> attributeValue) {
		ModelAndView map = new ModelAndView("notoriety");
		map.addObject("notorieties", attributeValue);
		map.addObject("faculties", facultyService.readAll());

		return map;
	}
}
