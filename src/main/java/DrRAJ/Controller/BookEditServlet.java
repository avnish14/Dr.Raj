package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookBean;
import DrRAJ.DAO.BookDAO;

@SuppressWarnings("serial")
public class BookEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		BookBean bean = new BookDAO().getByPK(bookId);
		if (bean != null) {
			request.setAttribute("bookBean", bean);
			request.getRequestDispatcher("BookEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("BookListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
