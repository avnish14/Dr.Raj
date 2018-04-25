package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.AdminBean;
import DrRAJ.DAO.AdminDAO;

public class AdminEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		AdminBean bean = new AdminDAO().getByPK(adminId);
		if (bean != null) {
			request.setAttribute("adminBean", bean);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("AdminListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
