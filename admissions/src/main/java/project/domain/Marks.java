package project.domain;

import java.util.Objects;

public class Marks {

	private Integer id;

	private Integer exam;

	private Integer interview;

	private Integer certificate;

	private Integer userId;

	public Marks() {
	}

	public Marks(Integer exam, Integer interview, Integer certificate, Integer userId) {
		this.exam = exam;
		this.interview = interview;
		this.certificate = certificate;
		this.userId = userId;
	}

	public Marks(Integer id, Integer exam, Integer interview, Integer certificate, Integer userId) {
		this.id = id;
		this.exam = exam;
		this.interview = interview;
		this.certificate = certificate;
		this.userId = userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificate, exam, id, interview, userId);
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
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", exam=" + exam + ", interview=" + interview + ", certificate=" + certificate
				+ ", userId=" + userId + "]";
	}

}
