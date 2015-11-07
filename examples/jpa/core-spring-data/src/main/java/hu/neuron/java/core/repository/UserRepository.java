package hu.neuron.java.core.repository;

import hu.neuron.java.core.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface UserRepository extends JpaRepository<User, Long> {

	//@Query("SELECT u FROM User u  WHERE u.userName = :userName")
	User findUserByUserName(@Param("userName") String name) throws Exception;

}
