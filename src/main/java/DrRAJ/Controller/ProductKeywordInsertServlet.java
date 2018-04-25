package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductKeywordBean;
import DrRAJ.DAO.ProductKeywordDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

@SuppressWarnings("serial")
public class ProductKeywordInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("txtKeyword");
		String productId = request.getParameter("productId");

		ProductKeywordBean bean = new ProductKeywordBean();
		boolean isError = false;

		if (ValidationUtils.isEmpty(keyword)) {
			isError = true;
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
			request.getRequestDispatcher("ProductKeywordInsert.jsp").forward(request, response);
		} else {

			bean.setProductKeywordId(GenrateMathodsUtils.getRandomString(15));
			if (new ProductKeywordDAO().insert(bean)) {
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
