package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookTypeBean;
import DrRAJ.DAO.BookTypeDAO;
import DrRAJ.Utils.ValidationUtils;

public class BookTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookTypeName = request.getParameter("txtBookTypeName");
		String bookTypeId = request.getParameter("bookTypeId");
		BookTypeBean bookTypeBean = new BookTypeBean();

		boolean isError = false;
		if (ValidationUtils.isEmpty(bookTypeName)) {
			isError = true;
			request.setAttribute("bookTypeName", "<font color=red>* BookType Name is Required</font>");
		} else if (new BookTypeDAO().isBookTypeExists(bookTypeName)) {
			isError = true;
			request.setAttribute("bookTypeName", "<font color=red>* BookType Name is Already Exists</font>");
		} else {
			request.setAttribute("txtBookTypeName", bookTypeName);
			bookTypeBean.setName(bookTypeName);
		}

		if (isError) {
			bookTypeBean.setName(bookTypeName);
			request.setAttribute("bookTypeBean", bookTypeBean);
			request.getRequestDispatcher("BookTypeEdit.jsp").forward(request, response);
		} else {
			bookTypeBean.setTypeId(bookTypeId);
			if (new BookTypeDAO().update(bookTypeBean)) {
				response.sendRedirect("BookTypeListServlet");
			} else {
				response.sendRedirect("BookTypeListServlet");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
