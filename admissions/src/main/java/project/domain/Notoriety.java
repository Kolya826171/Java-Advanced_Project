package project.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notoriety")
public class Notoriety {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "average_point")
	private Double averagePoint;
	
	@Column(name = "faculty_name")
	private String facultyName;

	@OneToOne(mappedBy = "notoriety")
	private User user;
	
	public Notoriety() {
	}

	public Notoriety(User user, Double averagePoint, String facultyName) {
		this.user = user;
		this.averagePoint = averagePoint;
		this.facultyName = facultyName;
	}

	public Notoriety(Integer id, User user, Double averagePoint, String facultyName) {
		this.id = id;
		this.user = user;
		this.averagePoint = averagePoint;
		this.facultyName = facultyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public int hashCode() {
		return Objects.hash(averagePoint, facultyName, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notoriety other = (Notoriety) obj;
		return Objects.equals(averagePoint, other.averagePoint) && Objects.equals(facultyName, other.facultyName)
				&& Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Notoriety [id=" + id + ", averagePoint=" + averagePoint + ", facultyName=" + facultyName + "]";
	}

}
