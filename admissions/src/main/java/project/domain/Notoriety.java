package project.domain;

import java.util.Objects;

public class Notoriety {

	private Integer id;

	private User user;

	private Double averagePont;

	public Notoriety() {
	}

	public Notoriety(User user, Double averagePont) {
		this.user = user;
		this.averagePont = averagePont;
	}

	public Notoriety(Integer id, User user, Double averagePont) {
		this.id = id;
		this.user = user;
		this.averagePont = averagePont;
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

	public Double getAveragePont() {
		return averagePont;
	}

	public void setAveragePont(Double averagePont) {
		this.averagePont = averagePont;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averagePont, id, user);
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
		return Objects.equals(averagePont, other.averagePont) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Notoriety [id=" + id + ", user=" + user + ", averagePont=" + averagePont + "]";
	}

}
