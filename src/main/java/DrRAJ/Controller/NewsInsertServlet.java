package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.NewsBean;
import DrRAJ.DAO.NewsDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class NewsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = request.getParameter("txtContent");
		String photoLink = request.getParameter("txtPhotoLink");
		String title = request.getParameter("txtTitle");

		NewsBean newsBean = new NewsBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", "<font color=red>* Content is Required</font>");
		} else {
			request.setAttribute("txtNewsContent", content);
			newsBean.setContent(content);
		}

		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", "<font color=red>* Photo Link is Required</font>");
		} else {
			request.setAttribute("txtPhotoLink", photoLink);
			newsBean.setPhotoLink(photoLink);
		}

		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("title", "<font color=red>* Title is Required</font>");
		} else {
			request.setAttribute("txtTitle", title);
			newsBean.setTitle(title);
		}

		if (isError) {
			request.getRequestDispatcher("NewsInsert.jsp").forward(request, response);
		} else {
			newsBean.setNewsId(GenrateMathodsUtils.getRandomString(15));
			if (new NewsDAO().insert(newsBean)) {
				response.sendRedirect("NewsListServlet");
			} else {
				request.getRequestDispatcher("NewsInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
