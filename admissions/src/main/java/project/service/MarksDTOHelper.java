package project.service;

import java.io.IOException;
import java.util.List;

import project.domain.User;
import project.domain.UserMarksDTO;

public class MarksDTOHelper {

	public static UserMarksDTO createEntity(User user) throws IOException {

		UserMarksDTO userMarksDTO = new UserMarksDTO();

		userMarksDTO.setId(user.getId());
		userMarksDTO.setFirstName(user.getFirstName());
		userMarksDTO.setLastName(user.getLastName());
		userMarksDTO.setEmail(user.getEmail());
		userMarksDTO.setExam(user.getMarks().getExam());
		userMarksDTO.setInterview(user.getMarks().getInterview());
		userMarksDTO.setCertificate(user.getMarks().getCertificate());
		userMarksDTO.setFacultyName(user.getFaculty().getName());

		return userMarksDTO;
	}

	public static List<UserMarksDTO> createList(List<User> user) {

		List<UserMarksDTO> usersMarks = user.stream().map(t -> {
			try {
				return createEntity(t);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}).toList();

		return usersMarks;
	}
}
