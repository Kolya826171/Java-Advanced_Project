package project.service;

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
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setUserRole(UserRole.ROLE_ADMIN);
		userRepo.save(user);
	}
}
