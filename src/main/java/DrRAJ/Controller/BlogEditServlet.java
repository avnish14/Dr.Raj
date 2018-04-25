package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BlogBean;
import DrRAJ.DAO.BlogDAO;

@SuppressWarnings("serial")
public class BlogEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String blogId = request.getParameter("blogId");
		BlogBean bean = new BlogDAO().getByPK(blogId);

		if (bean != null) {
			System.out.println(bean.getBlogId());
			request.setAttribute("blogBean", bean);
			request.getRequestDispatcher("BlogEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("BlogListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
