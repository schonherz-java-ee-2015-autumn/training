package hu.neuron.java.core.repository;

public interface RoleRepositoryCustom {

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

}
