package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.ProductKeywordDAO;

@SuppressWarnings("serial")
public class ProductKeywordDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productKeywordId");
		if (new ProductKeywordDAO().delete(productId)) {
			response.sendRedirect("ProductKeywordListServlet");
		} else {
			response.sendRedirect("ProductKeywordListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
