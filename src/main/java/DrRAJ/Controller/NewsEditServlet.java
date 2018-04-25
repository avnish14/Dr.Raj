package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.NewsBean;
import DrRAJ.DAO.NewsDAO;

public class NewsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newsId = request.getParameter("newsId");

		NewsBean newsBean = new NewsDAO().getByPK(newsId);

		if (newsBean != null) {
			request.setAttribute("newsBean", newsBean);
			request.getRequestDispatcher("NewsEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("NewsEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
