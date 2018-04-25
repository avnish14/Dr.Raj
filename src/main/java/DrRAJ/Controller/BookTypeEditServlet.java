package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookTypeBean;
import DrRAJ.DAO.BookTypeDAO;

public class BookTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookTypeId = request.getParameter("bookTypeId");

		BookTypeBean bookTypeBean = new BookTypeDAO().getByPK(bookTypeId);

		if (bookTypeBean != null) {
			request.setAttribute("bookTypeBean", bookTypeBean);
			request.getRequestDispatcher("BookTypeEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("BookTypeEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
