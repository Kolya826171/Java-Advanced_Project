package project.domain;

import java.util.Objects;
import java.util.stream.DoubleStream;

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

	@Column
	private Boolean inNotoriety;

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

	public Marks(Integer exam, Integer interview, Integer certificate, Boolean inNotoriety, User user) {
		this.exam = exam;
		this.interview = interview;
		this.certificate = certificate;
		this.inNotoriety = inNotoriety;
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

	public Boolean isInNotoriety() {
		return inNotoriety;
	}

	public void setInNotoriety(Boolean inNotoriety) {
		this.inNotoriety = inNotoriety;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificate, exam, id, inNotoriety, interview, user);
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
				&& Objects.equals(id, other.id) && inNotoriety == other.inNotoriety
				&& Objects.equals(interview, other.interview) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", exam=" + exam + ", interview=" + interview + ", certificate=" + certificate
				+ ", inNotoriety=" + inNotoriety + ", user=" + user + "]";
	}

	public Double getAvgPoint() {
		return DoubleStream.of(exam, interview, certificate).average().getAsDouble();
	}

}
