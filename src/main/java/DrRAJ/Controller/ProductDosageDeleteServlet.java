package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.ProductDosageDAO;

/**
 * Servlet implementation class ProductDosageDeleteServlet
 */
public class ProductDosageDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productDosageId = request.getParameter("productDosageId");
		if (new ProductDosageDAO().delete(productDosageId)) {
			request.getServletContext().removeAttribute("productDosageMap");
			HashMap<String, ArrayList<ProductDosageBean>> productDosageMap = new ProductDAO().getDosage();
			request.getServletContext().setAttribute("productDosageMap", productDosageMap);
			response.sendRedirect("ProductDosageListServlet");
		} else {
			response.sendRedirect("ProductDosageListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
