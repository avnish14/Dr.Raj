package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.SubBlogDAO;

@SuppressWarnings("serial")
public class SubBlogDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subBlogId = request.getParameter("subBlogId");
		if (new SubBlogDAO().delete(subBlogId)) {
			response.sendRedirect("SubBlogListServlet");
		} else {
			response.sendRedirect("SubBlogListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
