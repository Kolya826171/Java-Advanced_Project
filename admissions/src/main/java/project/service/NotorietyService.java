package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.NotorietyRepository;
import project.domain.Notoriety;
import project.domain.User;

@Service
public class NotorietyService {

	private Logger logger = LoggerFactory.getLogger(NotorietyService.class);
	
	@Autowired
	private NotorietyRepository notorietyRepo;

	public Notoriety findById(Integer id) {
		logger.info("Get notoriety item {} by id:" + id);
		return notorietyRepo.findById(id).get();
	}
	
	public void deleteById(Integer id) {
		logger.info("Delete notoriety item {} by id:" + id);
		notorietyRepo.deleteById(id);
	}

	public List<Notoriety> findAll() {
		logger.info("Get all notorieties {}");
		return notorietyRepo.findAll();
	}
	
}
