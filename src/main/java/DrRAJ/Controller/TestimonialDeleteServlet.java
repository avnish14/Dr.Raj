package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.TestimonialDAO;

/**
 * Servlet implementation class TestimonialDeleteServlet
 */
public class TestimonialDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String testimonialId = request.getParameter("testimonialId");

		if (new TestimonialDAO().delete(testimonialId)) {
			response.sendRedirect("TestimonialListServlet");
		} else {
			response.sendRedirect("TestimonialListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
