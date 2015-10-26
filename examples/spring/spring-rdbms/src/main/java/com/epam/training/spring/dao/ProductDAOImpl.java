package com.epam.training.spring.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=true,
		rollbackFor=PersistenceException.class, propagation=Propagation.SUPPORTS)
public class ProductDAOImpl extends JdbcDaoSupport implements ProductDAO {

	private SimpleJdbcInsert insert;
	
	public void init() {
		insert = new SimpleJdbcInsert(getDataSource())
			.withTableName("product")
			.usingGeneratedKeyColumns("id");
	}
	
	@Override
	@Transactional(readOnly=false)
	public Long save(ProductDTO product) throws PersistenceException {
		try {
			Number id = insert.executeAndReturnKey(
				new BeanPropertySqlParameterSource(product)
			);
			
			if( id != null ) {
				return id.longValue();
			}
			
			return null;
			
		} catch(DataAccessException e) {
			throw new PersistenceException(e);
		}
	}
}
