package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.RemediesDAO;

public class RemediesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String remediesId = request.getParameter("remediesId");

		if (new RemediesDAO().delete(remediesId)) {
			request.getServletContext().removeAttribute("remediesMap");
			HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
			request.getServletContext().setAttribute("remediesMap", remediesMap);
			response.sendRedirect("RemediesListServlet");
		} else {
			response.sendRedirect("RemediesListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
