package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.RemediesDAO;

public class RemediesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<RemediesBean> listOfRemedies = new RemediesDAO().getList();

		if (listOfRemedies != null) {
			request.setAttribute("listOfRemedies", listOfRemedies);
			request.getRequestDispatcher("RemediesList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("RemediesList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
