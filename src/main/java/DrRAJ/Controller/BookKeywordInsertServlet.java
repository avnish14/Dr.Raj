package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookKeywordBean;
import DrRAJ.DAO.BookKeywordDAO;
import DrRAJ.Utils.ValidationUtils;

@SuppressWarnings("serial")
public class BookKeywordInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("txtKeyword");
		String bookId = request.getParameter("bookId");

		BookKeywordBean bean = new BookKeywordBean();
		boolean isError = false;

		if (ValidationUtils.isEmpty(keyword)) {
			isError = true;
			request.setAttribute("keyWord", " <font color='red'> * Keyword is Required </font>");
		} else {
			request.setAttribute("txtKeyword", keyword);
			bean.setKeyword(keyword);
		}

		if (bookId.equals("0")) {
			isError = true;
			request.setAttribute("book", " <font color='red'> * Book is Required </font>");
		} else {
			request.setAttribute("bookId", bookId);
			bean.setBookId(bookId);
		}

		if (isError) {
			request.getRequestDispatcher("BookKeywordInsert.jsp").forward(request, response);
		} else {

			if (new BookKeywordDAO().insert(bean)) {
				request.getRequestDispatcher("BookKeywordListServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("BookKeywordListServlet").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
