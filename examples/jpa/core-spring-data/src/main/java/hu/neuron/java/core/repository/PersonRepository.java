package hu.neuron.java.core.repository;

import hu.neuron.java.core.entity.Family;
import hu.neuron.java.core.entity.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findPersonsByFamily(Family family) throws Exception;

	List<Person> findByFirstNameAndLastName(String firstName, String lastName)
			throws Exception;

	List<Person> findByJobJobDescr(String jobDescr) throws Exception;
}
