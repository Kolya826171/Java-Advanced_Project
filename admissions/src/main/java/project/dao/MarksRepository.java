package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {


}
