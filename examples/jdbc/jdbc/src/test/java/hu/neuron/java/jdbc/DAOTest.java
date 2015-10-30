package hu.neuron.java.jdbc;

import hu.neuron.java.jdbc.dao.DAOFactory;
import hu.neuron.java.jdbc.dao.RegistrationDAO;
import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DAOTest extends TestCase {
	public void testDAO() {
		DAOFactory instance = DAOFactory.getInstance();
		try {
			instance.beginConnectionScope();
			try {
				instance.beginTransaction();

				RegistrationDAO dao = instance.getRegistrationDAO();

				RegistrationDTO dto = new RegistrationDTO(null, "A", "B", 20);

				Long id = dao.save(dto);

				dto.setId(id);

//				dao.delete(id);

				dto.setFirstName("C");
				
//				if (true) {
//					throw new RuntimeException();
//				}

				Assert.assertEquals(1, dao.update(dto));

				instance.endTransaction();
			} catch (Exception ex) {
				ex.printStackTrace();
				instance.abortTransaction();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				instance.endConnectionScope();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void testDAOSelect() {
		DAOFactory instance = DAOFactory.getInstance();
		Date date = new Date();
		try {
			instance.beginConnectionScope();
			try {
				instance.beginTransaction();

				RegistrationDAO dao = instance.getRegistrationDAO();

				for (int i = 0; i < 100; i++) {

					dao.findAll();

				}

				instance.endTransaction();
			} catch (Exception ex) {
				instance.abortTransaction();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				instance.endConnectionScope();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Select with dao: "
				+ (new Date().getTime() - date.getTime()));

	}

	public void testDAOSelectParalel() {

		Date date = new Date();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {

			Runnable worker = new Thread() {
				@Override
				public void run() {
					DAOFactory instance = DAOFactory.getInstance();
					try {
						instance.beginConnectionScope();
						try {
							instance.beginTransaction();

							RegistrationDAO dao = null;
							try {
								dao = instance.getRegistrationDAO();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							for (int i = 0; i < 10; i++) {
								try {
									dao.findAll();
								} catch (Exception e) {
									e.printStackTrace();
								}

							}
						} catch (Exception ex) {
							instance.abortTransaction();
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							instance.endConnectionScope();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			executor.execute(worker);

		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Select with dao paralel: "
				+ (new Date().getTime() - date.getTime()));

	}
}
