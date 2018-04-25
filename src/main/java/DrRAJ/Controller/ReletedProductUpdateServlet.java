package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RelatedProductBean;
import DrRAJ.DAO.ReletedProductDAO;
import DrRAJ.Utils.ValidationUtils;

public class ReletedProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("txtProductId");
		String relatedId = request.getParameter("txtRelatedProductId");
		String relatedProductId = request.getParameter("reletedProductId");

		RelatedProductBean relatedProductBean = new RelatedProductBean();
		relatedProductBean.setReletedProductId(relatedProductId);

		boolean isError = false;

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("product", "<font color=red>* Product is Required</font>");
		} else {
			request.setAttribute("txtProductId", productId);
			relatedProductBean.setProductId(productId);
		}

		if (ValidationUtils.isEmpty(relatedId) || relatedId.equals("0")) {
			isError = true;
			request.setAttribute("relatedProduct", "<font color=red>* Related Product is Required</font>");
		} else {
			request.setAttribute("txtRelatedProductId", relatedProductId);
			relatedProductBean.setReletedId(relatedId);
		}

		if (productId.equals(relatedId)) {
			isError = true;
			request.setAttribute("relatedProduct", "<font color=red>* This relation is not required</font>");
		}

		if (isError) {
			relatedProductBean.setReletedProductId(relatedProductId);
			request.setAttribute("relatedProductBean", relatedProductBean);
			request.getRequestDispatcher("RelatedProductEdit.jsp").forward(request, response);
		} else {

			if (new ReletedProductDAO().isExists(relatedProductBean)) {

				request.setAttribute("relatedProduct", "<font color=red>* Already Exists</font>");
				request.getRequestDispatcher("RelatedProductEdit.jsp").forward(request, response);

			} else {
				relatedProductBean.setReletedProductId(relatedProductId);
				if (new ReletedProductDAO().update(relatedProductBean)) {
					response.sendRedirect("ReletedProductListServlet");
				} else {
					request.getRequestDispatcher("RelatedProductEdit.jsp").forward(request, response);
				}
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
