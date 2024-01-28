package project.domain;

import java.util.Objects;

public class Faculty {

	private Integer id;

	private String name;

	private Integer numberOfGovermentOrders;

	private Integer numberOfContractPlaces;

	public Faculty() {
	}

	public Faculty(String name, Integer numberOfGovermentOrders, Integer numberOfContractPlaces) {
		this.name = name;
		this.numberOfGovermentOrders = numberOfGovermentOrders;
		this.numberOfContractPlaces = numberOfContractPlaces;
	}

	public Faculty(Integer id, String name, Integer numberOfGovermentOrders, Integer numberOfContractPlaces) {
		this.id = id;
		this.name = name;
		this.numberOfGovermentOrders = numberOfGovermentOrders;
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

	public Integer getNumberOfGovermentOrders() {
		return numberOfGovermentOrders;
	}

	public void setNumberOfGovermentOrders(Integer numberOfGovermentOrders) {
		this.numberOfGovermentOrders = numberOfGovermentOrders;
	}

	public Integer getNumberOfContractPlaces() {
		return numberOfContractPlaces;
	}

	public void setNumberOfContractPlaces(Integer numberOfContractPlaces) {
		this.numberOfContractPlaces = numberOfContractPlaces;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, numberOfContractPlaces, numberOfGovermentOrders);
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
				&& Objects.equals(numberOfGovermentOrders, other.numberOfGovermentOrders);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfGovermentOrders=" + numberOfGovermentOrders
				+ ", numberOfContractPlaces=" + numberOfContractPlaces + "]";
	}

}
