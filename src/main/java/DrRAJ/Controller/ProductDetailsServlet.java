package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductBean;
import DrRAJ.DAO.ProductDAO;

public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getParameter("productId");
		System.out.println(url + " URL");
		ProductBean product = new ProductDAO().getByURL(url);
		new ProductDAO().cntIncrement(url);
		if (product != null) {
			request.setAttribute("product", product);
			request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
