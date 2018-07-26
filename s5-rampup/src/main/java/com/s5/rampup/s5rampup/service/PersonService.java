package com.s5.rampup.s5rampup.service;

import com.s5.rampup.s5rampup.domain.Person;
import com.s5.rampup.s5rampup.persistence.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public Person createPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        personMapper.createPerson(person);

        return person;
    }

    public Person updatePerson(int id, String firstName, String lastName) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        personMapper.updatePerson(person);

        return person;
    }

    public Person getPerson(int id) {
        return personMapper.getPerson(id);
    }

    public List<Person> getPeople() {
        return personMapper.getPeople();
    }

    public void deletePerson(int id) {
        personMapper.deletePerson(id);
    }
}
