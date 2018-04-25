package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoBean;
import DrRAJ.DAO.PressInfoDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class PressInfoInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("txtPressInfoType");
		String title = request.getParameter("txtTitle");
		String urlLink = request.getParameter("txtURLLink");

		PressInfoBean bean = new PressInfoBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("title", " <font color='red'> * Title is Required </font>");
		} else {
			request.setAttribute("txtTitle", title);
			bean.setTitle(title);
		}

		if (ValidationUtils.isEmpty(type) || type.equals("0")) {
			isError = true;
			request.setAttribute("type", " <font color='red'> * Type is Required </font>");
		} else {
			request.setAttribute("txtPressInfoType", type);
			bean.setTypeId(type);
		}

		if (ValidationUtils.isEmpty(urlLink)) {
			isError = true;
			request.setAttribute("URLLink", " <font color='red'> * URLLink is Required </font>");
		} else {
			request.setAttribute("txtBookURLLink", urlLink);
			bean.setLink(urlLink);

		}

		if (isError) {
			request.getRequestDispatcher("PressInfoInsert.jsp").forward(request, response);
		} else {
			bean.setPressInfoId(GenrateMathodsUtils.getRandomString(15));
			if (new PressInfoDAO().insert(bean)) {
				response.sendRedirect("PressInfoListServlet");
				// request.getRequestDispatcher("IngredientListServlet").forward(request,
				// response);

			} else {
				request.getRequestDispatcher("PressInfoInsert.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
