package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.domain.Notoriety;

@Repository
public interface NotorietyRepository extends JpaRepository<Notoriety, Integer> {

	@Modifying
	@Query(value = "delete from notoriety n where n.id = ?1", nativeQuery = true)
	void deleteById(Integer id);
}
