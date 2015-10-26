package com.epam.training.spring.dao;

public interface ProductDAO {
	
	Long save(ProductDTO product) throws PersistenceException;

}
