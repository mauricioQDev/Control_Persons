package com.umanizales.persons.service;

import com.umanizales.persons.domain.Person;
import java.util.List;

public interface PersonService {

    List<Person> listPersons();

    void save(Person person);
    
    void delete(Person person);

    Person findPerson(Person person);

}
