package com.s5.rampup.s5rampup;

import com.s5.rampup.s5rampup.domain.Person;
import com.s5.rampup.s5rampup.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"../../../../../resources/test-config.xml"})
public class PersonIntegrationIT {

    public static final String NEW_FIRST_NAME = "First name updated";
    public static final String NEW_LAST_NAME = "Last name updated";
    @Autowired
    private PersonService personService;

    private static boolean dataLoaded = false;

    @Before
    public void setUp() {
        if (!dataLoaded) {
            personService.createPerson("Carrie", "Mathison");
            personService.createPerson("Saul", "Berenson");
            personService.createPerson("Jessica", "Brody");

            dataLoaded = true;
        }
    }

    @Test
    public void should_get_all() {
        List<Person> people = personService.getPeople();
        Assert.assertTrue(people.size() > 0);
    }

    @Test
    public void should_get_by_id() {
        List<Person> people = personService.getPeople();
        int firstPersonId = people.get(0).getId();
        Person person = personService.getPerson(firstPersonId);
        Assert.assertEquals(firstPersonId, person.getId());
    }

    @Test
    public void should_insert() {
        Person person = personService.createPerson("Peter", "Quinn");

        person = personService.getPerson(person.getId());

        Assert.assertTrue(person.getFirstName().contains("Peter"));
        Assert.assertTrue(person.getLastName().contains("Quinn"));
    }

    @Test
    public void should_delete() {
        personService.deletePerson(1);

        Person person = personService.getPerson(1);
        Assert.assertNull(person);
    }

    @Test
    public void should_update() {
        Person person = personService.createPerson("Dar", "Adal");
        person = personService.getPerson(person.getId());

        personService.updatePerson(person.getId(), "First name updated", "Last name updated");
        person = personService.getPerson(person.getId());

        Assert.assertTrue(person.getFirstName().contains(NEW_FIRST_NAME));
        Assert.assertTrue(person.getLastName().contains(NEW_LAST_NAME));
    }
}
