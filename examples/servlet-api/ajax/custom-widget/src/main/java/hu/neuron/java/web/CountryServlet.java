package hu.neuron.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CountryServlet
 */
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CountryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String term = request.getParameter("term");
		String[] locales = Locale.getISOCountries();

		ArrayList<Helper> arrayList = new ArrayList<Helper>();
		for (String countryCode : locales) {

			Locale locale = new Locale("", countryCode);

			String displayName = locale.getDisplayName();
			if (countryCode.toUpperCase().contains(term.toUpperCase())){
				arrayList.add(new Helper(countryCode, displayName));
			}
		}
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		gson.toJson(arrayList, response.getWriter());
	}

}
