package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.CompanyManagementDAO;

/**
 * Servlet implementation class CompanyManagementDeleteServlet
 */
public class CompanyManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String companyManagementId = request.getParameter("companyManagementId");

		if (new CompanyManagementDAO().delete(companyManagementId)) {
			response.sendRedirect("CompanyManagementListServlet");
		} else {
			response.sendRedirect("CompanyManagementListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
