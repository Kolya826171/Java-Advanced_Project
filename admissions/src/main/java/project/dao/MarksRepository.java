package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.domain.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
