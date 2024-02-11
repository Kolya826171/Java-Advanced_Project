package project.domain;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column
	private String email;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@Column
	private String password;

	@Transient
	private String passwordConfirm;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String encodedImage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;

	@OneToOne(cascade = CascadeType.ALL)
	private Marks marks;

	@OneToOne(cascade = CascadeType.ALL)
	private Notoriety notoriety;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public User(String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm, Faculty faculty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.faculty = faculty;
	}

	public User(String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm, Faculty faculty, Marks marks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.faculty = faculty;
		this.marks = marks;
	}

	public User(String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm, Faculty faculty, Marks marks, Notoriety notoriety) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.faculty = faculty;
		this.marks = marks;
		this.notoriety = notoriety;
	}

	public User(Integer id, String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public User(Integer id, String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm, Faculty faculty) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.faculty = faculty;
	}

	public User(Integer id, String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm, Faculty faculty, Marks marks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.faculty = faculty;
		this.marks = marks;
	}

	public User(Integer id, String firstName, String lastName, String email, UserRole userRole, String password,
			String passwordConfirm, Faculty faculty, Marks marks, Notoriety notoriety) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.faculty = faculty;
		this.marks = marks;
		this.notoriety = notoriety;
	}

	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email;
		this.userRole = user.userRole;
		this.password = user.password;
		this.passwordConfirm = user.passwordConfirm;
		this.faculty = user.faculty;
		this.marks = user.marks;
		this.notoriety = user.notoriety;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	public Notoriety getNotoriety() {
		return notoriety;
	}

	public void setNotoriety(Notoriety notoriety) {
		this.notoriety = notoriety;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(faculty, other.faculty)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(marks, other.marks)
				&& Objects.equals(notoriety, other.notoriety) && Objects.equals(password, other.password)
				&& Objects.equals(passwordConfirm, other.passwordConfirm) && userRole == other.userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", password=" + password + ", passwordConfirm=" + passwordConfirm
				+ ", faculty=" + faculty + ", marks=" + marks + ", notoriety=" + notoriety + "]";
	}

}
