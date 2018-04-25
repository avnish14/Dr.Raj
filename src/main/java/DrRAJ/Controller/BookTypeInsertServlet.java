package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookTypeBean;
import DrRAJ.DAO.BookTypeDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class BookTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookTypeName = request.getParameter("txtBookTypeName");
		BookTypeBean bookTypeBean = new BookTypeBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(bookTypeName)) {
			isError = true;
			request.setAttribute("bookTypeName", "<font color=red>* BookType Name is Required</font>");
		} else if (new BookTypeDAO().isBookTypeExists(bookTypeName)) {
			isError = true;
			request.setAttribute("bookTypeName", "<font color=red>* BookType Name is Already Exists</font>");
			request.setAttribute("txtBookTypeName", bookTypeName);
		} else {
			request.setAttribute("txtBookTypeName", bookTypeName);
			bookTypeBean.setName(bookTypeName);
		}

		if (isError) {
			request.getRequestDispatcher("BookTypeInsert.jsp").forward(request, response);
		} else {
			bookTypeBean.setTypeId(GenrateMathodsUtils.getRandomString(15));
			if (new BookTypeDAO().insert(bookTypeBean)) {
				response.sendRedirect("BookTypeListServlet");
			} else {
				request.getRequestDispatcher("BookTypeInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
