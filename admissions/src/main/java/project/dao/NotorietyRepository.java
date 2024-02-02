package project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Notoriety;

@Repository
public interface NotorietyRepository extends JpaRepository<Notoriety, Integer> {

	List<Notoriety> findByFacultyIdOrderByAveragePointDesc(Integer facultyId);
}
