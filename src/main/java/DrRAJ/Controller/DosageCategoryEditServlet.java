package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.DosageCategoryBean;
import DrRAJ.DAO.DosageCategoryDAO;

public class DosageCategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dosageCategoryId = request.getParameter("dosageCategoryId");

		DosageCategoryBean productCategoryBean = new DosageCategoryDAO().getByPK(dosageCategoryId);

		if (productCategoryBean != null) {
			request.setAttribute("dosageCategoryBean", productCategoryBean);
			request.getRequestDispatcher("DosageCategoryEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("DosageCategoryEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
