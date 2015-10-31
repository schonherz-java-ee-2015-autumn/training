package com.epam.training.spring.dao;

import java.util.List;

public interface ProductDAO {
	
	Long save(ProductDTO product) throws PersistenceException;
	List<ProductDTO> findAll() throws PersistenceException;

}
