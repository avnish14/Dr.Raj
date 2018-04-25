package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ReviewBean;
import DrRAJ.DAO.ReviewDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String customerName = request.getParameter("txtCustomerName");
		String productId = request.getParameter("txtProductId");
		String rating = request.getParameter("txtRating");
		String description = request.getParameter("txtDescription");
		String title = request.getParameter("txtTitle");
		ReviewBean reviewBean = new ReviewBean();
		boolean isError = false;

		if (ValidationUtils.isEmpty(customerName)) {
			isError = true;
			request.setAttribute("customerName", "<font color=red>* Customer Name is Required</font>");
		} else {
			request.setAttribute("txtCustomerName", customerName);
			reviewBean.setCustomerName(customerName);
		}

		if (ValidationUtils.isEmpty(rating)) {
			isError = true;
			request.setAttribute("rating", "<font color=red>* Rating is Required</font>");
		} else {
			request.setAttribute("txtRating", rating);
			reviewBean.setRating(Integer.parseInt(rating));
		}

		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("title", "<font color=red>* Title is Required</font>");
		} else {
			request.setAttribute("txtTitle", title);
			reviewBean.setTitle(title);
		}

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("productId", "<font color=red>* Product Name is Required</font>");
		} else {
			request.setAttribute("productId", productId);
			reviewBean.setProductId(productId);
		}

		if (ValidationUtils.isEmpty(description)) {
			isError = true;
			request.setAttribute("description", "<font color=red>* Description is Required</font>");
		} else {
			request.setAttribute("txtDescription", description);
			reviewBean.setDescription(description);
		}

		if (isError) {
			request.getRequestDispatcher("ReviewInsert.jsp").forward(request, response);
		} else {
			reviewBean.setIsValid("0");
			reviewBean.setReviewId(GenrateMathodsUtils.getRandomString(15));
			if (new ReviewDAO().insert(reviewBean)) {
				response.sendRedirect("ReviewListServlet");
			} else {
				request.getRequestDispatcher("ReivewInsert.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
