package com.s5.rampup.s5rampup.persistence;

import com.s5.rampup.s5rampup.domain.Person;

import java.util.List;

public interface PersonMapper {
    void createPerson(Person person);
    void updatePerson(Person person);
    Person getPerson(int id);
    List<Person> getPeople();
    void deletePerson(int id);
}
