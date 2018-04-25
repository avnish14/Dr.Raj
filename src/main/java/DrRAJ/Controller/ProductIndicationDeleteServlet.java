package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.ProductIndicationDAO;

/**
 * Servlet implementation class ProductDeleteServlet
 */
public class ProductIndicationDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productIndicationId = request.getParameter("productIndicationId");
		if (new ProductIndicationDAO().delete(productIndicationId)) {
			request.getServletContext().removeAttribute("productIndicationMap");
			HashMap<String, ArrayList<ProductIndicationBean>> productIndicationMap = new ProductDAO().getIndication();
			request.getServletContext().setAttribute("productIndicationMap", productIndicationMap);
			response.sendRedirect("ProductIndicationListServlet");
		} else {
			response.sendRedirect("ProductIndicationListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
