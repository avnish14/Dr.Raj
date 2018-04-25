package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.RemediesDAO;
import DrRAJ.Utils.ValidationUtils;

public class RemediesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtRemediesName");
		String photoLink = request.getParameter("txtPhotoLink");
		String remediesId = request.getParameter("remediesId");
		String forwardLink = request.getParameter("txtForwardLink");
		RemediesBean remediesBean = new RemediesBean();
		remediesBean.setRemediesId(remediesId);
		boolean isError = false;

		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
		} else {
			request.setAttribute("txtRemediesName", name);
			remediesBean.setName(name);
		}

		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", "<font color=red>* Photo Link is Required</font>");
		} else {
			request.setAttribute("txtPhotoLink", photoLink);
			remediesBean.setPhotolink(photoLink);
		}

		if (ValidationUtils.isEmpty(forwardLink)) {
			isError = true;
			request.setAttribute("forwardLink", "<font color=red>* Forward Link is Required</font>");
		} else {
			request.setAttribute("txtForwardLink", forwardLink);
			remediesBean.setForwardLink(forwardLink);
		}

		if (isError) {
			request.setAttribute("remediesBean", remediesBean);
			request.getRequestDispatcher("RemediesEdit.jsp").forward(request, response);
		} else {
			if (new RemediesDAO().update(remediesBean)) {
				request.getServletContext().removeAttribute("remediesMap");
				HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
				request.getServletContext().setAttribute("remediesMap", remediesMap);
				response.sendRedirect("RemediesListServlet");
			} else {
				request.getRequestDispatcher("RemediesEdit.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
