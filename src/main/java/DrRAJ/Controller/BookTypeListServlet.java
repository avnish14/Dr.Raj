package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookTypeBean;
import DrRAJ.DAO.BookTypeDAO;

public class BookTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookTypeBean> listOfBookType = new BookTypeDAO().getList();

		if (listOfBookType != null) {
			request.setAttribute("listOfBookType", listOfBookType);
			request.getRequestDispatcher("BookTypeList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("BookTypeList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
