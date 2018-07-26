package com.s5.rampup.s5rampup.controller;

import com.s5.rampup.s5rampup.domain.Person;
import com.s5.rampup.s5rampup.dto.PersonDto;
import com.s5.rampup.s5rampup.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/people", method=RequestMethod.POST)
    public Person createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto.getFirstName(), personDto.getLastName());
    }

    @RequestMapping(value="/people/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto.getId(), personDto.getFirstName(), personDto.getLastName());
    }

    @RequestMapping(value = "/people/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @RequestMapping(value = "/people")
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }
}
