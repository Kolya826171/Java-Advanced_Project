package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.*;

import project.dao.FacultyRepository;
import project.dao.MarksRepository;
import project.dao.NotorietyRepository;
import project.dao.UserRepository;
import project.domain.Faculty;
import project.domain.Marks;
import project.domain.Notoriety;
import project.domain.User;
import project.domain.UserRole;
import project.service.FacultyService;
import project.service.MarksService;
import project.service.NotorietyService;
import project.service.UserService;

@SpringBootTest
class AdmissionsApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private MarksService marksService;

	@Autowired
	private NotorietyService notorietyService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FacultyRepository facultyRepo;

	@Autowired
	private MarksRepository marksRepo;

	@Autowired
	private NotorietyRepository notorietyRepo;

	@AfterEach
	void clearTables() {
		userRepo.deleteAll();
		notorietyRepo.deleteAll();
		marksRepo.deleteAll();
		facultyRepo.deleteAll();
	}

	private User getUser() {
		User user = new User();
		user.setFirstName("1");
		user.setLastName("1");
		user.setEmail("1@gmail.com");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setEncodedImage("1");
		user.setUserRole(UserRole.ROLE_USER);

		return user;
	}

	private Faculty getFaculty() {
		Faculty faculty = new Faculty();
		faculty.setName("111");
		faculty.setNumberOfGovernmentOrders(22);
		faculty.setNumberOfContractPlaces(10);

		return faculty;
	}

	private Marks getMarks() {
		Marks marks = new Marks();
		marks.setExam(66);
		marks.setInterview(77);
		marks.setCertificate(88);

		return marks;
	}

	private Notoriety getNotoriety(Marks marks) {
		Notoriety notoriety = new Notoriety();
		notoriety.setAveragePoint(marks.getAvgPoint());
		notoriety.setFacultyName("111");

		return notoriety;
	}

	@Test
	void testSaveUser() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		User user = getUser();

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		User userFromDB = users.get(0);
		
		assertTrue(userFromDB.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user.getLastName()));
		assertTrue(userFromDB.getEmail().equals(user.getEmail()));
		assertTrue(userFromDB.getPassword().equals(user.getPassword()));
		assertTrue(userFromDB.getUserRole().equals(user.getUserRole()));
		assertTrue(userFromDB.getEncodedImage().equals(user.getEncodedImage()));
	}

	@Test
	void testSaveUserWithPassword() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		User user = getUser();
		String password = "2";

		userService.save(user, password);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		User userFromDB = users.get(0);
		
		assertTrue(userFromDB.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user.getLastName()));
		assertTrue(userFromDB.getEmail().equals(user.getEmail()));
		assertTrue(userFromDB.getPassword().equals(password));
		assertTrue(userFromDB.getUserRole().equals(user.getUserRole()));
		assertTrue(userFromDB.getEncodedImage().equals(user.getEncodedImage()));
	}

	@Test
	void testFindByRole() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		User user = getUser();

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		users = userService.findByRole(UserRole.ROLE_USER);
		User findByRole = users.get(0);
		
		assertTrue(findByRole.getFirstName().equals(user.getFirstName()));
		assertTrue(findByRole.getLastName().equals(user.getLastName()));
		assertTrue(findByRole.getEmail().equals(user.getEmail()));
		assertTrue(findByRole.getPassword().equals(user.getPassword()));
		assertTrue(findByRole.getUserRole().equals(user.getUserRole()));
		assertTrue(findByRole.getEncodedImage().equals(user.getEncodedImage()));
	}

	@Test
	void testFindByEmail() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		User user = getUser();

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		User findByEmail = userService.findByEmail(user.getEmail());
		
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getPassword().equals(user.getPassword()));
		assertTrue(findByEmail.getUserRole().equals(user.getUserRole()));
		assertTrue(findByEmail.getEncodedImage().equals(user.getEncodedImage()));
	}

	@Test
	void testFindWithMarks() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		Marks marks = getMarks();

		User user = getUser();
		user.setMarks(marks);

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		users = userService.findWithMarks();
		User findWithMarks = users.get(0);
		Marks marksFromDB = findWithMarks.getMarks();
		
		assertTrue(findWithMarks.getFirstName().equals(user.getFirstName()));
		assertTrue(findWithMarks.getLastName().equals(user.getLastName()));
		assertTrue(findWithMarks.getEmail().equals(user.getEmail()));
		assertTrue(findWithMarks.getPassword().equals(user.getPassword()));
		assertTrue(findWithMarks.getUserRole().equals(user.getUserRole()));
		assertTrue(findWithMarks.getEncodedImage().equals(user.getEncodedImage()));

		assertTrue(marksFromDB.getInterview().equals(marks.getInterview()));
		assertTrue(marksFromDB.getCertificate().equals(marks.getCertificate()));
		assertTrue(marksFromDB.getExam().equals(marks.getExam()));
	}

	@Test
	void testFindByIdUser() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		User user = getUser();
		user.setId(1);

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		User findWithMarks = userService.findById(user.getId());
		
		assertTrue(findWithMarks.getFirstName().equals(user.getFirstName()));
		assertTrue(findWithMarks.getLastName().equals(user.getLastName()));
		assertTrue(findWithMarks.getEmail().equals(user.getEmail()));
		assertTrue(findWithMarks.getPassword().equals(user.getPassword()));
		assertTrue(findWithMarks.getUserRole().equals(user.getUserRole()));
		assertTrue(findWithMarks.getId().equals(user.getId()));
		assertTrue(findWithMarks.getEncodedImage().equals(user.getEncodedImage()));
	}

	@Test
	void testFindWithNotoriety() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		Marks marks = getMarks();
		Notoriety notoriety = getNotoriety(marks);

		User user = getUser();
		user.setMarks(marks);
		user.setNotoriety(notoriety);

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		users = userService.findWithNotoriety();
		User findWithNotoriety = users.get(0);
		Marks marksFromDB = findWithNotoriety.getMarks();
		Notoriety notorietyFromDB = findWithNotoriety.getNotoriety();
		
		assertTrue(findWithNotoriety.getFirstName().equals(user.getFirstName()));
		assertTrue(findWithNotoriety.getLastName().equals(user.getLastName()));
		assertTrue(findWithNotoriety.getEmail().equals(user.getEmail()));
		assertTrue(findWithNotoriety.getPassword().equals(user.getPassword()));
		assertTrue(findWithNotoriety.getUserRole().equals(user.getUserRole()));
		assertTrue(findWithNotoriety.getEncodedImage().equals(user.getEncodedImage()));

		assertTrue(marksFromDB.getInterview().equals(marks.getInterview()));
		assertTrue(marksFromDB.getCertificate().equals(marks.getCertificate()));
		assertTrue(marksFromDB.getExam().equals(marks.getExam()));

		assertTrue(notorietyFromDB.getFacultyName().equals(notoriety.getFacultyName()));
		assertTrue(notorietyFromDB.getAveragePoint().equals(notoriety.getAveragePoint()));
	}

	@Test
	void testFindByFacultyWithNotoriety() {
		List<User> users = userService.findAll();
		assertTrue(users.size() == 0);

		Marks marks = getMarks();
		Notoriety notoriety = getNotoriety(marks);

		User user = getUser();
		user.setMarks(marks);
		user.setNotoriety(notoriety);

		userService.save(user);

		users = userService.findAll();
		assertTrue(users.size() == 1);

		Faculty faculty = getFaculty();
		facultyService.save(faculty);

		User userFromDB = userService.findByEmail(user.getEmail());

		faculty = facultyService.findByName(faculty.getName());
		userFromDB.setFaculty(faculty);
		Set<User> usersSet = faculty.getUsers();
		usersSet.add(userFromDB);

		facultyService.save(faculty);

		Integer facultyId = facultyService.findByName(faculty.getName()).getId();

		users = userService.findByFacultyWithNotoriety(facultyId);
		User findByFacultyWithNotoriety = users.get(0);
		Marks marksFromDB = findByFacultyWithNotoriety.getMarks();
		Notoriety notorietyFromDB = findByFacultyWithNotoriety.getNotoriety();
		Faculty facultyFromDB = findByFacultyWithNotoriety.getFaculty();
		
		assertTrue(findByFacultyWithNotoriety.getFirstName().equals(user.getFirstName()));
		assertTrue(findByFacultyWithNotoriety.getLastName().equals(user.getLastName()));
		assertTrue(findByFacultyWithNotoriety.getEmail().equals(user.getEmail()));
		assertTrue(findByFacultyWithNotoriety.getPassword().equals(user.getPassword()));
		assertTrue(findByFacultyWithNotoriety.getUserRole().equals(user.getUserRole()));
		assertTrue(findByFacultyWithNotoriety.getEncodedImage().equals(user.getEncodedImage()));

		assertTrue(marksFromDB.getInterview().equals(marks.getInterview()));
		assertTrue(marksFromDB.getCertificate().equals(marks.getCertificate()));
		assertTrue(marksFromDB.getExam().equals(marks.getExam()));

		assertTrue(notorietyFromDB.getFacultyName().equals(notoriety.getFacultyName()));
		assertTrue(notorietyFromDB.getAveragePoint().equals(notoriety.getAveragePoint()));

		assertTrue(facultyFromDB.getName().equals(faculty.getName()));
		assertTrue(facultyFromDB.getNumberOfGovernmentOrders().equals(faculty.getNumberOfGovernmentOrders()));
		assertTrue(facultyFromDB.getNumberOfContractPlaces().equals(faculty.getNumberOfContractPlaces()));
	}

	@Test
	void testSaveFaculty() {
		List<Faculty> faculties = facultyService.readAll();
		assertTrue(faculties.size() == 0);

		Faculty faculty = getFaculty();

		facultyService.save(faculty);

		faculties = facultyService.readAll();
		assertTrue(faculties.size() == 1);

		Faculty facultyFromDB = faculties.get(0);
		
		assertTrue(facultyFromDB.getName().equals(faculty.getName()));
		assertTrue(facultyFromDB.getNumberOfGovernmentOrders().equals(faculty.getNumberOfGovernmentOrders()));
		assertTrue(facultyFromDB.getNumberOfContractPlaces().equals(faculty.getNumberOfContractPlaces()));
	}

	@Test
	void testFindByIdFaculty() {
		List<Faculty> faculties = facultyService.readAll();
		assertTrue(faculties.size() == 0);

		Faculty faculty = getFaculty();
		faculty.setId(1);

		facultyService.save(faculty);

		faculties = facultyService.readAll();
		assertTrue(faculties.size() == 1);

		Faculty facultyFromDB = facultyService.findById(faculty.getId());
		
		assertTrue(facultyFromDB.getName().equals(faculty.getName()));
		assertTrue(facultyFromDB.getNumberOfGovernmentOrders().equals(faculty.getNumberOfGovernmentOrders()));
		assertTrue(facultyFromDB.getNumberOfContractPlaces().equals(faculty.getNumberOfContractPlaces()));
		assertTrue(facultyFromDB.getId().equals(faculty.getId()));
	}

	@Test
	void testFindByName() {
		List<Faculty> faculties = facultyService.readAll();
		assertTrue(faculties.size() == 0);

		Faculty faculty = getFaculty();

		facultyService.save(faculty);

		faculties = facultyService.readAll();
		assertTrue(faculties.size() == 1);

		Faculty facultyFromDB = facultyService.findByName(faculty.getName());
		
		assertTrue(facultyFromDB.getName().equals(faculty.getName()));
		assertTrue(facultyFromDB.getNumberOfGovernmentOrders().equals(faculty.getNumberOfGovernmentOrders()));
		assertTrue(facultyFromDB.getNumberOfContractPlaces().equals(faculty.getNumberOfContractPlaces()));
	}

	@Test
	void testSaveMarks() {
		List<Marks> marksList = marksService.findAll();
		assertTrue(marksList.size() == 0);

		Marks marks = getMarks();

		marksService.save(marks);

		marksList = marksService.findAll();
		assertTrue(marksList.size() == 1);

		Marks marksFromDB = marksList.get(0);
		
		assertTrue(marksFromDB.getExam().equals(marks.getExam()));
		assertTrue(marksFromDB.getInterview().equals(marks.getInterview()));
		assertTrue(marksFromDB.getCertificate().equals(marks.getCertificate()));
	}

	@Test
	void testFindByIdNotoriety() {
		List<Notoriety> notorieties = notorietyService.findAll();
		assertTrue(notorieties.size() == 0);

		Marks marks = getMarks();

		Notoriety notoriety = getNotoriety(marks);
		notoriety.setId(1);

		User user = getUser();
		user.setMarks(marks);

		userService.save(user);
		User userFromDB = userService.findByEmail(user.getEmail());
		userFromDB.setNotoriety(notoriety);
		userService.save(userFromDB, userFromDB.getPassword());

		notorieties = notorietyService.findAll();
		assertTrue(notorieties.size() == 1);

		Notoriety notorietyFromDB = notorietyService.findById(notoriety.getId());
		
		assertTrue(notorietyFromDB.getFacultyName().equals(notoriety.getFacultyName()));
		assertTrue(notorietyFromDB.getAveragePoint().equals(notoriety.getAveragePoint()));
		assertTrue(notorietyFromDB.getId().equals(notoriety.getId()));
	}

	@Test
	void testDeleteNotoriety() {
		List<Notoriety> notorieties = notorietyService.findAll();
		assertTrue(notorieties.size() == 0);

		Marks marks = getMarks();
		Notoriety notoriety = getNotoriety(marks);

		User user = getUser();
		user.setId(1);
		user.setMarks(marks);
		user.setNotoriety(notoriety);
		
		userService.save(user);

		notorieties = notorietyService.findAll();
		assertTrue(notorieties.size() == 1);

		User userFromDB = userService.findById(user.getId()); 
		notoriety = userFromDB.getNotoriety();
		userFromDB.setNotoriety(null);
		notorietyService.deleteById(notoriety.getId());
		
		notorieties = notorietyService.findAll();
		assertTrue(notorieties.size() == 0);
	}
}