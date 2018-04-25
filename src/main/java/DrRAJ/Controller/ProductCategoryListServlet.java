package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductCategoryBean;
import DrRAJ.DAO.ProductCategoryDAO;

public class ProductCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductCategoryBean> listOfProductCategory = new ProductCategoryDAO().getList();

		if (listOfProductCategory != null) {
			request.setAttribute("listOfProductCategory", listOfProductCategory);
			request.getRequestDispatcher("ProductCategoryList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("ProductCategoryList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
