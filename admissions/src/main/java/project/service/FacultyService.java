package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.FacultyRepository;
import project.domain.Faculty;

@Service
public class FacultyService {

	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	private FacultyRepository facultyRepo;

	public Faculty save(Faculty faculty) {
		logger.info("Create new faculty item {}: " + faculty);
		return facultyRepo.save(faculty);
	}
	
	public List<Faculty> readAll() {
		logger.info("Get all faculties items");
		return facultyRepo.findAll();
	}
	
	public Faculty findById(Integer id) {
		logger.info("Get faculty item {} by id: " + id);
		return facultyRepo.findById(id).get();
	}
	
	public Faculty findByName(String name) {
		logger.info("Get faculty item {} by name: " + name);
		return facultyRepo.findByName(name);
	}
}
