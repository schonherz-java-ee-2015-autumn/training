package hu.schonherz.training.java.spring.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.training.spring.dao.ProductDTO;
import com.epam.training.spring.service.ProductService;
import com.epam.training.spring.service.ServiceException;

/**
 * Servlet implementation class ProductCreationServlet
 */
@WebServlet("/product")
public class ProductCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService service;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductCreationServlet() {
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext ctx =
			WebApplicationContextUtils
				.findWebApplicationContext(config.getServletContext());

		this.service = ctx.getBean("productService", ProductService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDTO product = new ProductDTO();
		product.setShortName("short");
		product.setLongName("long");
		product.setCategory("cat");
		product.setNetPrice(123);
		product.setVat(23.45);
		product.setDescription("desc");
		product.setBrand("brand");
		product.setIsChinese(false);

		Long savedId = -1L;
		try {
			savedId = this.service.save(product);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		response.getWriter().append("Service saved product with id: ").append(savedId.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
