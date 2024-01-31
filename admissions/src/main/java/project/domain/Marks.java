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
@Table(name = "marks")
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Integer exam;

	@Column
	private Integer interview;

	@Column
	private Integer certificate;

	@OneToOne(mappedBy = "marks")
	private User user;

	public Marks() {
	}

	public Marks(Integer exam, Integer interview, Integer certificate, User user) {
		this.exam = exam;
		this.interview = interview;
		this.certificate = certificate;
		this.user = user;
	}

	public Marks(Integer id, Integer exam, Integer interview, Integer certificate, User user) {
		this.id = id;
		this.exam = exam;
		this.interview = interview;
		this.certificate = certificate;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExam() {
		return exam;
	}

	public void setExam(Integer exam) {
		this.exam = exam;
	}

	public Integer getInterview() {
		return interview;
	}

	public void setInterview(Integer interview) {
		this.interview = interview;
	}

	public Integer getCertificate() {
		return certificate;
	}

	public void setCertificate(Integer certificate) {
		this.certificate = certificate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificate, exam, id, interview, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marks other = (Marks) obj;
		return Objects.equals(certificate, other.certificate) && Objects.equals(exam, other.exam)
				&& Objects.equals(id, other.id) && Objects.equals(interview, other.interview)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", exam=" + exam + ", interview=" + interview + ", certificate=" + certificate
				+ ", user=" + user + "]";
	}

}
