package hu.neuron.java.core.test;

import java.util.List;

import hu.neuron.java.core.entity.Person;
import hu.neuron.java.core.repository.PersonRepository;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class PersonRepositoryTest {

	private static final Logger logger = Logger
			.getLogger(UserRepositoryTest.class);

	@Autowired
	PersonRepository personRepository;

	@Test
	public void test1FindNames() {
		try {
			List<Person> persons = personRepository.findByFirstNameAndLastName(
					"a0", "b0");
			logger.debug(persons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2FindJobs() {
		try {
			List<Person> persons = personRepository.findByJobJobDescr("job0");
			logger.debug(persons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
