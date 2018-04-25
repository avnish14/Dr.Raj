package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.AdminBean;
import DrRAJ.DAO.AdminDAO;

public class AdminListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<AdminBean> list = new AdminDAO().select();
		if (list != null) {
			request.setAttribute("adminList", list);
			request.getRequestDispatcher("AdminList.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("AdminList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
