package com.umanizales.persons.service;

import com.umanizales.persons.dao.PersonDao;
import com.umanizales.persons.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Person> listPersons() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return personDao.findById(person.getIdPerson()).orElse(null);
    }
}
