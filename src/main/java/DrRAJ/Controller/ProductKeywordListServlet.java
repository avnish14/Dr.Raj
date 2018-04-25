package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductKeywordBean;
import DrRAJ.DAO.ProductKeywordDAO;

public class ProductKeywordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductKeywordBean> listOfProductKeyword = new ProductKeywordDAO().getList();

		if (listOfProductKeyword != null) {
			request.setAttribute("listOfProductKeyword", listOfProductKeyword);
			request.getRequestDispatcher("ProductKeywordList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("ProductKeywordList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
