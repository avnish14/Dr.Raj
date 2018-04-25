package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.DosageCategoryBean;
import DrRAJ.DAO.DosageCategoryDAO;
import DrRAJ.DAO.ProductCategoryDAO;
import DrRAJ.Utils.ValidationUtils;

public class DosageCategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dosageCategoryName = request.getParameter("txtDosageCategoryName");
		String dosageCategoryId = request.getParameter("dosageCategoryId");
		DosageCategoryBean dosageCategoryBean = new DosageCategoryBean();

		boolean isError = false;
		if (ValidationUtils.isEmpty(dosageCategoryName)) {
			isError = true;
			request.setAttribute("dosageCategoryName", "<font color=red>* ProductCategory Name is Required</font>");
		} else if (new ProductCategoryDAO().isProductCategoryExists(dosageCategoryName)) {
			isError = true;
			request.setAttribute("dosageCategoryName",
					"<font color=red>* ProductCategory Name is Already Exists</font>");
		} else {
			request.setAttribute("txtDosageCategoryName", dosageCategoryName);
			dosageCategoryBean.setDosageCategoryName(dosageCategoryName);
		}

		if (isError) {
			dosageCategoryBean.setDosageCategoryName(dosageCategoryName);
			request.setAttribute("dosageCategoryBean", dosageCategoryBean);
			request.getRequestDispatcher("DosageCategoryEdit.jsp").forward(request, response);
		} else {
			dosageCategoryBean.setDosageCategoryid(dosageCategoryId);
			if (new DosageCategoryDAO().update(dosageCategoryBean)) {
				response.sendRedirect("DosageCategoryListServlet");
			} else {
				response.sendRedirect("DosageCategoryListServlet");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
