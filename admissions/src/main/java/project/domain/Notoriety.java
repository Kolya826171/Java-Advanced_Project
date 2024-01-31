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
	
	@Column(name = "faculty_id")
	private Integer facultyId;

	@OneToOne(mappedBy = "notoriety")
	private User user;
	
	public Notoriety() {
	}

	public Notoriety(User user, Double averagePoint, Integer facultyId) {
		this.user = user;
		this.averagePoint = averagePoint;
		this.facultyId = facultyId;
	}

	public Notoriety(Integer id, User user, Double averagePoint, Integer facultyId) {
		this.id = id;
		this.user = user;
		this.averagePoint = averagePoint;
		this.facultyId = facultyId;
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

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averagePoint, facultyId, id, user);
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
		return Objects.equals(averagePoint, other.averagePoint) && Objects.equals(facultyId, other.facultyId)
				&& Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Notoriety [id=" + id + ", user=" + user + ", averagePoint=" + averagePoint + ", facultyId=" + facultyId
				+ "]";
	}

}
