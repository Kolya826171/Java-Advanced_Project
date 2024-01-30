package project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.domain.Notoriety;

public interface NotorietyRepository extends JpaRepository<Notoriety, Integer> {

	List<Notoriety> findByFacultyIdOrderByAveragePointDesc(Integer facultyId);
}
