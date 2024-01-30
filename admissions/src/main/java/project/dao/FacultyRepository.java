package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	Faculty findByName(String name);
}
