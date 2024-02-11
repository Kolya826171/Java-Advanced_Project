package project.service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import project.domain.NotorietyDTO;
import project.domain.User;

public class NotorietyDTOHelper {

	public static NotorietyDTO createEntity(User user) throws IOException {

		NotorietyDTO notorietyDTO = new NotorietyDTO();

		notorietyDTO.setId(user.getId());
		notorietyDTO.setFirstName(user.getFirstName());
		notorietyDTO.setLastName(user.getLastName());
		notorietyDTO.setEmail(user.getEmail());
		notorietyDTO.setAveragePoint(user.getMarks().getAvgPoint());
		notorietyDTO.setFacultyName(user.getFaculty().getName());

		return notorietyDTO;
	}

	public static List<NotorietyDTO> createList(List<User> user) {
		List<NotorietyDTO> notorietyDTO = user.stream().map(t -> {
			try {
				return createEntity(t);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}).sorted(Comparator.comparing(NotorietyDTO::getAveragePoint)).toList();

		return notorietyDTO;
	}
}
