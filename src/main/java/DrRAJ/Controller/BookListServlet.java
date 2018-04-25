package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookBean;
import DrRAJ.DAO.BookDAO;

public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookBean> listOfBook = new BookDAO().getList();

		if (listOfBook != null) {
			request.setAttribute("listOfBook", listOfBook);
			request.getRequestDispatcher("BookList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("BookList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
