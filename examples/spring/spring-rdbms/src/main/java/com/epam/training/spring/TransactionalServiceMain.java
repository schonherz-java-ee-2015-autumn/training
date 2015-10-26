package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.spring.dao.ProductDTO;
import com.epam.training.spring.service.ProductService;
import com.epam.training.spring.service.ServiceException;

public class TransactionalServiceMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ServiceException {

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
				"spring-part2-datasource-with-transaction.xml", "test-db.xml");
		
		ProductService service = context.getBean(
			"productService", ProductService.class);

		ProductDTO product = new ProductDTO();
    	product.setShortName("short");
    	product.setLongName("long");
    	product.setCategory("cat");
    	product.setNetPrice(123);
    	product.setVat(23.45);
    	product.setDescription("desc");
    	product.setBrand("brand");
    	product.setIsChinese(false);
		
    	Long savedId = service.save(product);

    	System.out.println(savedId);
	}

}
