package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.RemediesDAO;

public class RemediesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String remediesId = request.getParameter("remediesId");

		RemediesBean remediesBean = new RemediesDAO().getByPK(remediesId);

		if (remediesBean != null) {
			request.setAttribute("remediesBean", remediesBean);
			request.getRequestDispatcher("RemediesEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("RemediesEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
