package hu.neuron.java.core.repository;

import hu.neuron.java.core.entity.Family;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface FamilyRepository extends JpaRepository<Family, Long> {

}
