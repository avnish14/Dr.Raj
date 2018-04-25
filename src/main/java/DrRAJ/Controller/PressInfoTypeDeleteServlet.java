package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.PressInfoTypeDAO;

/**
 * Servlet implementation class PressInfoTypeDeleteServlet
 */
public class PressInfoTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pressInfoTypeId = request.getParameter("pressInfoTypeId");

		if (new PressInfoTypeDAO().delete(pressInfoTypeId)) {
			response.sendRedirect("PressInfoTypeListServlet");
		} else {
			response.sendRedirect("PressInfoTypeListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
