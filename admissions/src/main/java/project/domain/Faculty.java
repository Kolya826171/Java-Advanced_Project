package project.domain;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column(name = "government_places")
	private Integer numberOfGovernmentOrders;

	@Column(name = "contract_places")
	private Integer numberOfContractPlaces;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "faculty")
	@Column(nullable = true)
	private Set<User> users;
	
	public Faculty() {
	}

	public Faculty(String name, Integer numberOfGovernmentOrders, Integer numberOfContractPlaces) {
		this.name = name;
		this.numberOfGovernmentOrders = numberOfGovernmentOrders;
		this.numberOfContractPlaces = numberOfContractPlaces;
	}
	
	public Faculty(Integer id) {
		this.id = id;
	}

	public Faculty(Integer id, String name, Integer numberOfGovernmentOrders, Integer numberOfContractPlaces) {
		this.id = id;
		this.name = name;
		this.numberOfGovernmentOrders = numberOfGovernmentOrders;
		this.numberOfContractPlaces = numberOfContractPlaces;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfGovernmentOrders() {
		return numberOfGovernmentOrders;
	}

	public void setNumberOfGovernmentOrders(Integer numberOfGovernmentOrders) {
		this.numberOfGovernmentOrders = numberOfGovernmentOrders;
	}

	public Integer getNumberOfContractPlaces() {
		return numberOfContractPlaces;
	}

	public void setNumberOfContractPlaces(Integer numberOfContractPlaces) {
		this.numberOfContractPlaces = numberOfContractPlaces;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, numberOfContractPlaces, numberOfGovernmentOrders, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(numberOfContractPlaces, other.numberOfContractPlaces)
				&& Objects.equals(numberOfGovernmentOrders, other.numberOfGovernmentOrders)
				&& Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfGovermentOrders=" + numberOfGovernmentOrders
				+ ", numberOfContractPlaces=" + numberOfContractPlaces + "]";
	}

}
