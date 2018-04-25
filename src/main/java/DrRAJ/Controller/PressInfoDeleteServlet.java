package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.PressInfoDAO;

/**
 * Servlet implementation class PressInfoTypeDeleteServlet
 */
public class PressInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pressInfoId = request.getParameter("pressInfoId");

		if (new PressInfoDAO().delete(pressInfoId)) {
			response.sendRedirect("PressInfoListServlet");
		} else {
			response.sendRedirect("PressInfoListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
