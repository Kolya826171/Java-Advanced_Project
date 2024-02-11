package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Notoriety;

@Repository
public interface NotorietyRepository extends JpaRepository<Notoriety, Integer> {


}
