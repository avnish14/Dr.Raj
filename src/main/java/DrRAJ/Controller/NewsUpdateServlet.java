package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.NewsBean;
import DrRAJ.DAO.NewsDAO;
import DrRAJ.Utils.ValidationUtils;

public class NewsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = request.getParameter("txtContent");
		String photoLink = request.getParameter("txtPhotoLink");
		String title = request.getParameter("txtTitle");
		String newsId = request.getParameter("newsId");

		NewsBean newsBean = new NewsBean();

		newsBean.setNewsId(newsId);
		boolean isError = false;


		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", "<font color=red>* Content is Required</font>");
		} else {
			request.setAttribute("txtContent", content);
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
			// newsBean.setDescription(description);
			// newsBean.setContent(content);
			// newsBean.setPhotoLink(photoLink);
			// newsBean.setNewsId(newsId);
			System.out.println("HI");
			request.setAttribute("newsBean", newsBean);
			request.getRequestDispatcher("NewsEdit.jsp").forward(request, response);
		} else {
			if (new NewsDAO().update(newsBean)) {
				response.sendRedirect("NewsListServlet");
			} else {
				request.getRequestDispatcher("NewsEdit.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
