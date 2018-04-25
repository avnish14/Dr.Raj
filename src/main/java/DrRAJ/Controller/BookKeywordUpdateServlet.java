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
public class BookKeywordUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("txtKeyword");
		String bookId = request.getParameter("bookId");
		String bookKeywordId = request.getParameter("bookKeywordId");

		BookKeywordBean bean = new BookKeywordBean();
		bean.setBookKeywordId(bookKeywordId);
		bean.setBookId(bookId);
		boolean isError = false;

		if (ValidationUtils.isEmpty(keyword)) {
			isError = true;
			bean.setKeyword("");
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
			bean.setBookId(bookId);
			bean.setBookKeywordId(bookKeywordId);
			request.setAttribute("bookKeywordBean", bean);
			request.getRequestDispatcher("BookKeywordEdit.jsp").forward(request, response);
		} else {

			if (new BookKeywordDAO().update(bean)) {
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
