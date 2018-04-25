package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.SubBlogBean;
import DrRAJ.DAO.SubBlogDAO;

@SuppressWarnings("serial")
public class SubBlogEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subBlogId = request.getParameter("subBlogId");
		SubBlogBean bean = new SubBlogDAO().getByPK(subBlogId);

		if (bean != null) {
			System.out.println(bean.getSubBlogId());
			request.setAttribute("subBlogBean", bean);
			request.getRequestDispatcher("SubBlogEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("SubBlogListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
