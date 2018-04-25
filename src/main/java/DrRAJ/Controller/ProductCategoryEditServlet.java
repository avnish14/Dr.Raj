package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductCategoryBean;
import DrRAJ.DAO.ProductCategoryDAO;

public class ProductCategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productCategoryId = request.getParameter("productCategoryId");

		ProductCategoryBean productCategoryBean = new ProductCategoryDAO().getByPK(productCategoryId);

		if (productCategoryBean != null) {
			request.setAttribute("productCategoryBean", productCategoryBean);
			request.getRequestDispatcher("ProductCategoryEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("ProductCategoryEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
