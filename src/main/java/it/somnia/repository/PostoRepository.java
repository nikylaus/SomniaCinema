package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Posto;

@Repository
public interface PostoRepository extends CrudRepository<Posto, Integer>{

}
