package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BlogBean;
import DrRAJ.DAO.BlogDAO;

public class BlogListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BlogBean> listOfBlog = new BlogDAO().getList();

		if (listOfBlog != null) {
			request.setAttribute("listOfBlog", listOfBlog);
			request.getRequestDispatcher("BlogList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("BlogList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
