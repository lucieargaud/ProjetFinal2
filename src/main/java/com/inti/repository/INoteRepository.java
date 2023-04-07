package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Note;

@Repository
public interface INoteRepository extends JpaRepository<Note, Integer>{

	@Query(value="SELECT ROUND(AVG(valeur),1) from note", nativeQuery = true, countQuery = "count")
	double moyenneNotes();
}
