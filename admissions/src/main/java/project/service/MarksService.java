package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.MarksRepository;
import project.domain.Marks;

@Service
public class MarksService {

	private Logger logger = LoggerFactory.getLogger(MarksService.class);
	
	@Autowired
	private MarksRepository marksRepo;
	
	public Marks save(Marks marks) {
		logger.info("Create new marks item {}: " + marks);
		return marksRepo.save(marks);
	}
	
	public List<Marks> findAll() {
		logger.info("Get all marks items");
		return marksRepo.findAll();
	}
	
	
}
