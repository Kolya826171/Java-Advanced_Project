package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.dao.UserRepository;
import project.domain.User;
import project.domain.UserRole;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.ROLE_USER);
		userRepo.save(user);
	}

	public void save(User user, String password) {
		user.setPassword(password);
		user.setUserRole(UserRole.ROLE_USER);
		userRepo.save(user);
	}

	public List<User> findByRole(UserRole role) {
		return userRepo.findByUserRole(role);
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email).get();
	}

	public List<User> findWithMarks() {
		return userRepo.findByMarksNotNullAndNotorietyNull();
	}

	public User findById(Integer id) {
		return userRepo.findById(id).get();
	}

	public List<User> findWithNotoriety() {
		return userRepo.findByNotorietyNotNull();
	}
	
	public List<User> findByFacultyWithNotoriety(Integer id) {
		return userRepo.findByFacultyWithNotoriety(id);
	}
}
