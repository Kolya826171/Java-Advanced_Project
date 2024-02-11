package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.FacultyRepository;
import project.domain.Faculty;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepo;

	public Faculty save(Faculty faculty) {
		return facultyRepo.save(faculty);
	}
	
	public List<Faculty> readAll() {
		return facultyRepo.findAll();
	}
	
	public Faculty findById(Integer id) {
		return facultyRepo.findById(id).get();
	}
	
	public Faculty findByName(String name) {
		return facultyRepo.findByName(name);
	}
}
