package project.domain;

public class NotorietyDTO {

	Integer id;
	String firstName;
	String lastName;
	String email;
	Double averagePoint;
	String facultyName;

	public NotorietyDTO() {
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

	public Double getAveragePoint() {
		return averagePoint;
	}

	public void setAveragePoint(Double averagePoint) {
		this.averagePoint = averagePoint;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	
}
