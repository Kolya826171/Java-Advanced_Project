package project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.domain.User;
import project.domain.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
	List<User> findByUserRole(UserRole role);
	
	List<User> findByMarksNotNullAndNotorietyNull();
	
	List<User> findByNotorietyNotNull();
	
	@Query(value = "select * from user u where u.faculty_id = ?1 and u.notoriety_id is not null", nativeQuery = true)
	List<User> findByFacultyWithNotoriety(Integer id);
	
}
