package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoBean;
import DrRAJ.DAO.PressInfoDAO;
import DrRAJ.Utils.ValidationUtils;

public class PressInfoUpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("txtPressInfoType");
		String pressInfoId = request.getParameter("pressInfoId");
		String title = request.getParameter("txtTitle");
		String urlLink = request.getParameter("txtURLLink");
		System.out.println(pressInfoId);
		
		System.out.println(pressInfoId);
		System.out.println(pressInfoId);
		System.out.println(pressInfoId);

		PressInfoBean bean = new PressInfoBean();
		bean.setPressInfoId(pressInfoId);
		boolean isError = false;
		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("title", " <font color='red'> * Title is Required </font>");
			bean.setTitle("");
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
			bean.setLink("");
		} else {
			request.setAttribute("txtBookURLLink", urlLink);
			bean.setLink(urlLink);

		}

		if (isError) {
			request.setAttribute("pressInfoBean", bean);
			request.getRequestDispatcher("PressInfoEdit.jsp").forward(request, response);
		} else {
			if (new PressInfoDAO().update(bean)) {
				response.sendRedirect("PressInfoListServlet");
				// request.getRequestDispatcher("IngredientListServlet").forward(request,
				// response);

			} else {
				request.getRequestDispatcher("PressInfoEdit.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
