package com.epam.training.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.spring.dao.PersistenceException;
import com.epam.training.spring.dao.ProductDAO;
import com.epam.training.spring.dao.ProductDTO;

@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=true,
	rollbackFor=ServiceException.class, propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDao;
	
	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Long save(ProductDTO product) throws ServiceException {
		
		try {
			return productDao.save(product);
		} catch(PersistenceException e) {
			throw new ServiceException(e);
		}
		
	}
	
	@Override
	public List<ProductDTO> findAll() throws ServiceException {
		try {
			return this.productDao.findAll();
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

}
