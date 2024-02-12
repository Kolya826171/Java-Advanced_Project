package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.dao.UserRepository;
import project.domain.User;
import project.domain.UserRole;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		logger.info("Register new user {}: " + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.ROLE_USER);
		userRepo.save(user);
	}

	public void save(User user, String password) {
		logger.info("Update user {}: " + user);
		user.setPassword(password);
		user.setUserRole(UserRole.ROLE_USER);
		userRepo.save(user);
	}

	public List<User> findByRole(UserRole role) {
		logger.info("Get user {} by role: " + role);
		return userRepo.findByUserRole(role);
	}

	public User findByEmail(String email) {
		logger.info("Get user {} by email: " + email);
		return userRepo.findByEmail(email).get();
	}

	public List<User> findWithMarks() {
		logger.info("Get users {} which have marks and haven't notoriety");
		return userRepo.findByMarksNotNullAndNotorietyNull();
	}

	public User findById(Integer id) {
		logger.info("Get user {} by id: " + id);
		return userRepo.findById(id).get();
	}

	public List<User> findWithNotoriety() {
		logger.info("Get users {} which have notoriety");
		return userRepo.findByNotorietyNotNull();
	}
	
	public List<User> findByFacultyWithNotoriety(Integer id) {
		logger.info("Get users {} by faculty_id: " + id + " and which have notoriety");
		return userRepo.findByFacultyWithNotoriety(id);
	}
}
