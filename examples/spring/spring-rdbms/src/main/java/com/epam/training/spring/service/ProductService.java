package com.epam.training.spring.service;

import java.util.List;

import com.epam.training.spring.dao.ProductDTO;

public interface ProductService {
	
	Long save(ProductDTO product) throws ServiceException;
	
	List<ProductDTO> findAll() throws ServiceException;
	
}
