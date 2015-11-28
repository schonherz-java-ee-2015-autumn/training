package hu.neuron.java.service.webservice.rest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

import hu.neuron.java.service.UserServiceRemote;
import hu.neuron.java.service.vo.UserVO;

@Path("/users")
public class UserRestWebService {
	private static final Logger logger = Logger.getLogger(UserRestWebService.class);

	private static final DozerBeanMapper beanMapper = new DozerBeanMapper();

	@EJB
	UserServiceRemote serviceRemote;

	public void initEJB() {
		try {
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			env.put(Context.SECURITY_PRINCIPAL, "weblogic");
			env.put(Context.SECURITY_CREDENTIALS, "weblogic1");
			env.put(Context.PROVIDER_URL, "t3://localhost:7001");
			Context ctx;

			ctx = new InitialContext(env);

			logger.info("Initial Context created");
			serviceRemote = (UserServiceRemote) ctx.lookup("UserService#hu.neuron.java.service.UserServiceRemote");
			logger.info("lookup successful");
		} catch (NamingException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/list")
	public List<UserWebServiceVo> getUserList() {
		initEJB();
		logger.info("run web in: " + System.getProperty("weblogic.Name"));
		List<UserVO> userVos = serviceRemote.getUsers();

		List<UserWebServiceVo> rv = new ArrayList<>();

		for (UserVO userVo : userVos) {
			rv.add(beanMapper.map(userVo, UserWebServiceVo.class));
		}
		return rv;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{username}")
	public UserWebServiceVo getUser(@PathParam("username") String userName) {
		UserVO userVo = null;
		try {
			initEJB();
			userVo = serviceRemote.findUserByName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanMapper.map(userVo, UserWebServiceVo.class);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/id")
	public UserWebServiceVo getUserById(@QueryParam("id") Long id) {
		initEJB();
		UserVO userVo = serviceRemote.findById(id);
		return beanMapper.map(userVo, UserWebServiceVo.class);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/save")
	public UserWebServiceVo save(UserWebServiceVo serviceVo) {
		initEJB();
		UserVO userVo = null;
		try {
			userVo = serviceRemote.registrationUser(beanMapper.map(serviceVo, UserVO.class));
		} catch (MappingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanMapper.map(userVo, UserWebServiceVo.class);
	}
}