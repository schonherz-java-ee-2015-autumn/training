package hu.neuron.java.core.test;

import hu.neuron.java.core.entity.Family;
import hu.neuron.java.core.entity.Job;
import hu.neuron.java.core.entity.Person;
import hu.neuron.java.core.repository.FamilyRepository;
import hu.neuron.java.core.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

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
public class FamilyRepositoryTest {

	private static final Logger logger = Logger
			.getLogger(UserRepositoryTest.class);

	@Autowired
	FamilyRepository familyRepository;

	@Autowired
	PersonRepository personRepository;

	@Test
	public void test1saveFamily() {
		Family entity = new Family();
		entity.setDescription("Family");

		familyRepository.save(entity);
	}

	@Test
	public void test2saveFamily() {
		Family family = new Family();
		family.setDescription("FamilyWithMembers");
		List<Person> members = new ArrayList<Person>();

		Person e = new Person();
		e.setFirstName("a");
		e.setLastName("b");
		
		e.setFamily(family);

		Job job = new Job();
		job.setJobDescr("job");
		job.setSalery(20.2);
		
		
		e.setJob(job);
		members.add(e);

//		family.setMembers(members);

		familyRepository.save(family);
	}

	@Test
	public void test3saveFamilies() {
		for (int i = 0; i < 20; i++) {

			Family family = new Family();
			family.setDescription("FamilyWithMembers" + i);
			List<Person> members = new ArrayList<Person>();

			Person e = new Person();
			e.setFirstName("a" + i);
			e.setLastName("b" + i);
			e.setFamily(family);

			Job job = new Job();
			job.setJobDescr("job" + i);
			job.setSalery(20.2);
			e.setJob(job);
			members.add(e);

//			family.setMembers(members);

			familyRepository.save(family);
		}

	}

	@Test
	public void test4Read() {
		try {
			for (Family family : familyRepository.findAll()) {
				logger.debug(family.getDescription()
						+ " ----------------------------------------");
//				List<Person> members = family.getMembers();

//				for (Person person : members) {
//					logger.debug(person);
//					logger.debug(person.getJob());
//				}
			}
		} catch (StackOverflowError e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Test
	public void test4ReadWithFinders() {
		try {
			for (Family family : familyRepository.findAll()) {
				logger.debug(family.getDescription()
						+ " ----------------------------------------");
				List<Person> members = personRepository.findPersonsByFamily(family);

				for (Person person : members) {
					logger.debug(person);
					logger.debug(person.getJob());
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
