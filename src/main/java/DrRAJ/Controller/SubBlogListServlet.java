package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.SubBlogBean;
import DrRAJ.DAO.SubBlogDAO;

public class SubBlogListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<SubBlogBean> listOfSubBlog = new SubBlogDAO().getList();

		if (listOfSubBlog != null) {
			request.setAttribute("listOfSubBlog", listOfSubBlog);
			request.getRequestDispatcher("SubBlogList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("SubBlogList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
