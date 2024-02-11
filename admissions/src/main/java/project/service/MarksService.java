package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.MarksRepository;
import project.domain.Marks;

@Service
public class MarksService {

	@Autowired
	private MarksRepository marksRepo;
	
	public Marks save(Marks marks) {
		return marksRepo.save(marks);
	}
	
	public List<Marks> findAll() {
		return marksRepo.findAll();
	}
	
	
}
