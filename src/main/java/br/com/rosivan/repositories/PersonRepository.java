package br.com.rosivan.repositories;

import br.com.rosivan.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { // OBJETO E ID DO OBJETO
} // responsavel por gerar um crud
