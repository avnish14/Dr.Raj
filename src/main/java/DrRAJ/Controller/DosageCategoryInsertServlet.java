package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.DosageCategoryBean;
import DrRAJ.DAO.DosageCategoryDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class DosageCategoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dosageCategoryName = request.getParameter("txtDosageCategoryName");
		DosageCategoryBean dosageCategoryBean = new DosageCategoryBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(dosageCategoryName)) {
			isError = true;
			request.setAttribute("dosageCategoryName", "<font color=red>* Dosage Category Name is Required</font>");
		} else if (new DosageCategoryDAO().isDosageCategoryExists(dosageCategoryName)) {
			isError = true;
			request.setAttribute("dosageCategoryName",
					"<font color=red>* dosage Category Name is Already Exists</font>");
			request.setAttribute("txtDosageCategoryName", dosageCategoryName);
		} else {
			request.setAttribute("txtDosageCategoryName", dosageCategoryName);
			dosageCategoryBean.setDosageCategoryName(dosageCategoryName);
		}

		if (isError) {
			request.getRequestDispatcher("DosageCategoryInsert.jsp").forward(request, response);
		} else {
			dosageCategoryBean.setDosageCategoryid(GenrateMathodsUtils.getRandomString(15));
			if (new DosageCategoryDAO().insert(dosageCategoryBean)) {
				response.sendRedirect("DosageCategoryListServlet");
			} else {
				request.getRequestDispatcher("DosageCategoryInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
