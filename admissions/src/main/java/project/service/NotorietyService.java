package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.NotorietyRepository;
import project.domain.Notoriety;

@Service
public class NotorietyService {

	@Autowired
	private NotorietyRepository notorietyRepo;

	public Notoriety findById(Integer id) {
		return notorietyRepo.findById(id).get();
	}

	public void delete(Notoriety notoriety) {
		notorietyRepo.delete(notoriety);
	}

}
