package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductCompositionBean;
import DrRAJ.DAO.ProductCompositionDAO;
import DrRAJ.DAO.ProductDAO;

/**
 * Servlet implementation class ProductCompositionDeleteServlet
 */
public class ProductCompositionDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCompositionId = request.getParameter("productCompositionId");
		if (new ProductCompositionDAO().delete(productCompositionId)) {
			request.getServletContext().removeAttribute("productCompositionMap");
			HashMap<String, ArrayList<ProductCompositionBean>> productCompositionMap = new ProductDAO()
					.getComposition();
			request.getServletContext().setAttribute("productCompositionMap", productCompositionMap);
			response.sendRedirect("ProductCompositionListServlet");
		} else {
			response.sendRedirect("ProductCompositionListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
