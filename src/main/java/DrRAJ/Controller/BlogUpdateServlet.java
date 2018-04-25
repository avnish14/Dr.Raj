package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BlogBean;
import DrRAJ.DAO.BlogDAO;
import DrRAJ.Utils.ValidationUtils;

public class BlogUpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("txtBlogTitle");
		String date = request.getParameter("txtDate");
		String content = request.getParameter("txtBlogContent");
		String photoLink = request.getParameter("txtBlogPhotoLink");
		String urlLink = request.getParameter("txtBlogURLLink");
		String blogId = request.getParameter("blogId");

		BlogBean bean = new BlogBean();
		bean.setBlogId(blogId);
		boolean isError = false;
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("title", " <font color='red'> * Title is Required </font>");
			bean.setBlogTitle("");
		} else {
			request.setAttribute("txtBlogTitle", name);
			bean.setBlogTitle(name);
		}

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", " <font color='red'> * Discription is Required </font>");
			bean.setContent("");
		} else {
			request.setAttribute("txtBlogContent", content);
			bean.setContent(content);

		}
		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", " <font color='red'> * PhotoLink is Required </font>");
			bean.setImageLink("");
		} else {
			request.setAttribute("txtBlogPhotoLink", photoLink);
			bean.setImageLink(photoLink);

		}
		if (ValidationUtils.isEmpty(urlLink)) {
			isError = true;
			request.setAttribute("URLLink", " <font color='red'> * URLLink is Required </font>");
			bean.setUrlLink("");
		} else {
			request.setAttribute("txtBlogURLLink", urlLink);
			bean.setUrlLink(urlLink);

		}

		if (ValidationUtils.isEmpty(date)) {
			isError = true;
			request.setAttribute("date", " <font color='red'> * Date is Required </font>");
			bean.setDate("");
		} else {
			request.setAttribute("txtDate", date);
			bean.setDate(date);

		}

		if (isError) {
			request.setAttribute("blogBean", bean);
			request.getRequestDispatcher("BlogEdit.jsp").forward(request, response);
		} else {
			if (new BlogDAO().update(bean)) {
				response.sendRedirect("BlogListServlet");
			} else {
				request.getRequestDispatcher("BlogListServlet").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
