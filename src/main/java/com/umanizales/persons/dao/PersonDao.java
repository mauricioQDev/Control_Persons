package com.umanizales.persons.dao;

import com.umanizales.persons.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long>{
    
}
