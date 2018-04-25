package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.SubBlogBean;
import DrRAJ.DAO.SubBlogDAO;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class BlogCompositionInsertServlet
 */
public class SubBlogUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String subBlogId = request.getParameter("subBlogId");
		String blogId = request.getParameter("selBlogName");
		String content = request.getParameter("txtContent");
		String title = request.getParameter("txtTitle");
		SubBlogBean subBlogBean = new SubBlogBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(blogId) || blogId.equals("0")) {
			isError = true;
			request.setAttribute("blog", "<font color=red>* Blog Name is Required</font>");
		} else {
			request.setAttribute("selBlogName", blogId);
			subBlogBean.setBlogId(blogId);
		}

		if (ValidationUtils.isEmpty(title) || title.equals("0")) {
			isError = true;
			request.setAttribute("title", "<font color=red>*Title Name is Required</font>");
		} else {
			request.setAttribute("txtTitle", title);
			subBlogBean.setTitle(title);
		}

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", "<font color=red>* Content is Required</font>");
		} else {
			request.setAttribute("txtContent", content);
			subBlogBean.setContent(content);
		}

		if (isError) {
			subBlogBean.setTitle(title);
			subBlogBean.setBlogId(blogId);
			subBlogBean.setSubBlogId(subBlogId);
			subBlogBean.setContent(content);
			request.setAttribute("subBlogBean", subBlogBean);
			request.getRequestDispatcher("SubBlogEdit.jsp").forward(request, response);
		} else {
			subBlogBean.setSubBlogId(subBlogId);
			if (new SubBlogDAO().update(subBlogBean)) {
				response.sendRedirect("SubBlogListServlet");
			} else {
				request.getRequestDispatcher("SubBlogEdit.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
