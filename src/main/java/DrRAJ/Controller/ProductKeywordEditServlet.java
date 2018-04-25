package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductKeywordBean;
import DrRAJ.DAO.ProductKeywordDAO;

@SuppressWarnings("serial")
public class ProductKeywordEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productKeywordId");
		ProductKeywordBean bean = new ProductKeywordDAO().getByPK(productId);
		if (bean != null) {
			request.setAttribute("productKeywordBean", bean);
			request.getRequestDispatcher("ProductKeywordEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("ProductListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
