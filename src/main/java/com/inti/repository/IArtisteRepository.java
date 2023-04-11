package com.inti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Artiste;
@Repository
public interface IArtisteRepository extends JpaRepository<Artiste, Integer>{

	Artiste findByLogin(String login);
}
