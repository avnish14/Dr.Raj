package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DrRAJ.Bean.AdminBean;
import DrRAJ.DAO.AdminDAO;
import DrRAJ.Utils.ValidationUtils;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminEmail = request.getParameter("adminEmail");
		String adminPassword = request.getParameter("adminPassword");
		boolean isError = false;
		if (adminPassword == null) {
			adminPassword = "";
		}
		if (adminEmail == null) {
			adminEmail = "";
		}
		if (ValidationUtils.isEmpty(adminPassword)) {
			isError = true;
			request.setAttribute("adminPassword", "<font color=red>* PASSWORD is Required</font>");
		} else {
			request.setAttribute("txtAdminPassword", adminPassword);
		}

		if (ValidationUtils.isEmpty(adminEmail)) {
			isError = true;
			request.setAttribute("adminEmail", "<font color=red>* Username is Required</font>");
		}

		else {
			request.setAttribute("txtAdminEmail", adminEmail);
		}

		if (isError) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {

			AdminBean adminBean = new AdminDAO().login(adminEmail, adminPassword);
			if (adminBean != null) {

				HttpSession session = request.getSession();
				session.setAttribute("adminBean", adminBean);
				request.getRequestDispatcher("AdminDashBoard.jsp").forward(request, response);

			} else
				request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}
}