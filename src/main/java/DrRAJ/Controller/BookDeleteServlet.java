package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookBean;
import DrRAJ.DAO.BookDAO;

@SuppressWarnings("serial")
public class BookDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		if (new BookDAO().delete(bookId)) {
			request.getServletContext().removeAttribute("bookMap");
			HashMap<String, BookBean> bookMap = new BookDAO().getBookMap();
			request.getServletContext().setAttribute("bookMap", bookMap);
			response.sendRedirect("BookListServlet");
		} else {
			response.sendRedirect("BookListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
