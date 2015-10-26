package com.epam.training.spring.service;

import com.epam.training.spring.dao.ProductDTO;

public interface ProductService {
	
	Long save(ProductDTO product) throws ServiceException;
	
}
