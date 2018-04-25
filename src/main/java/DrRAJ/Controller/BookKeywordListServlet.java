package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookKeywordBean;
import DrRAJ.DAO.BookKeywordDAO;

public class BookKeywordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookKeywordBean> listOfBookKeyword = new BookKeywordDAO().getList();

		if (listOfBookKeyword != null) {
			request.setAttribute("listOfBookKeyword", listOfBookKeyword);
			request.getRequestDispatcher("BookKeywordList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("BookKeywordList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
