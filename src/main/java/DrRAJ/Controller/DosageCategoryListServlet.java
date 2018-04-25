package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.DosageCategoryBean;
import DrRAJ.DAO.DosageCategoryDAO;

public class DosageCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DosageCategoryBean> listOfdosageCategory = new DosageCategoryDAO().getList();

		if (listOfdosageCategory != null) {
			request.setAttribute("listOfdosageCategory", listOfdosageCategory);
			request.getRequestDispatcher("DosageCategoryList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("DosageCategoryList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
