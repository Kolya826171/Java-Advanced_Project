package project.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import project.domain.User;

public class UserDTOHelper {

	public static User createEntity(MultipartFile image, String firstName, String lastName, String email,
			String password, String passwordConfirm) throws IOException {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);
		user.setEncodedImage(Base64.getEncoder().encodeToString(image.getBytes()));
		
		return user;
	}
}
