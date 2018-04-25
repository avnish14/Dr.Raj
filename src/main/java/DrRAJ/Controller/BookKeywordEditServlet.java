package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookKeywordBean;
import DrRAJ.DAO.BookKeywordDAO;

@SuppressWarnings("serial")
public class BookKeywordEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookKeywordId");
		BookKeywordBean bean = new BookKeywordDAO().getByPK(bookId);
		if (bean != null) {
			request.setAttribute("bookKeywordBean", bean);
			request.getRequestDispatcher("BookKeywordEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("BookListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
