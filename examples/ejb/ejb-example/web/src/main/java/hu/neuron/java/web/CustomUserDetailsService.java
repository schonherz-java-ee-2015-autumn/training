package hu.neuron.java.web;

import hu.neruon.java.ejb.client.service.UserServiceBeanLocal;
import hu.neruon.java.ejb.client.vo.RoleVO;
import hu.neruon.java.ejb.client.vo.UserVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
@EJB(name = "hu.neuron.ejb.UserServiceBeanLocal", beanInterface = UserServiceBeanLocal.class)
public class CustomUserDetailsService implements UserDetailsService {

	@EJB
	UserServiceBeanLocal userService;

	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		UserVO user;
		try {
			user = userService.findUserByName(username);

			List<GrantedAuthority> authorities = buildUserAuthority(user
					.getRoles());

			return buildUserForAuthentication(user, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		}

	}

	private User buildUserForAuthentication(UserVO user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true,
				true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<RoleVO> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (RoleVO userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

}