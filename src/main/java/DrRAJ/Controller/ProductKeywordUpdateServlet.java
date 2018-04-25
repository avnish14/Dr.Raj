package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductKeywordBean;
import DrRAJ.DAO.ProductKeywordDAO;
import DrRAJ.Utils.ValidationUtils;

@SuppressWarnings("serial")
public class ProductKeywordUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("txtKeyword");
		String productId = request.getParameter("productId");
		String productKeywordId = request.getParameter("productKeywordId");

		ProductKeywordBean bean = new ProductKeywordBean();
		bean.setProductKeywordId(productKeywordId);
		bean.setProductId(productId);
		boolean isError = false;

		if (ValidationUtils.isEmpty(keyword)) {
			isError = true;
			bean.setKeyword("");
			request.setAttribute("keyWord", " <font color='red'> * Keyword is Required </font>");
		} else {
			request.setAttribute("txtKeyword", keyword);
			bean.setKeyword(keyword);
		}

		if (productId.equals("0")) {
			isError = true;
			request.setAttribute("product", " <font color='red'> * Product is Required </font>");
		} else {
			request.setAttribute("productId", productId);
			bean.setProductId(productId);
		}

		if (isError) {
			bean.setProductId(productId);
			bean.setProductKeywordId(productKeywordId);
			request.setAttribute("productKeywordBean", bean);
			request.getRequestDispatcher("ProductKeywordEdit.jsp").forward(request, response);
		} else {

			if (new ProductKeywordDAO().update(bean)) {
				request.getRequestDispatcher("ProductKeywordListServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("ProductKeywordListServlet").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
