package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.DosageCategoryDAO;

/**
 * Servlet implementation class ProductCategoryDeleteServlet
 */
public class DosageCategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dosageCategoryId = request.getParameter("dosageCategoryId");

		if (new DosageCategoryDAO().delete(dosageCategoryId)) {
			response.sendRedirect("DosageCategoryListServlet");
		} else {
			response.sendRedirect("DosageCategoryListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
