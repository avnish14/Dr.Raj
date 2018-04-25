package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.BookTypeDAO;

/**
 * Servlet implementation class BookTypeDeleteServlet
 */
public class BookTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookTypeId = request.getParameter("bookTypeId");

		if (new BookTypeDAO().delete(bookTypeId)) {
			response.sendRedirect("BookTypeListServlet");
		} else {
			response.sendRedirect("BookTypeListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
