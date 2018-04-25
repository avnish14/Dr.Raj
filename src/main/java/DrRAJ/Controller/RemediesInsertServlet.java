package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.RemediesDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class RemediesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtRemediesName");
		String photoLink = request.getParameter("txtPhotoLink");
		String remediesURL = request.getParameter("txtRemediesURL");
		RemediesBean remediesBean = new RemediesBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
		} else if (new RemediesDAO().isRemediesExists(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Already Exists</font>");
			request.setAttribute("txtRemediesName", name);
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
		
		if (ValidationUtils.isEmpty(remediesURL)) {
			isError = true;
			request.setAttribute("remediesURL", "<font color=red>* Remedies URL Link is Required</font>");
		} else {
			request.setAttribute("txtRemediesURL", remediesURL);
			remediesBean.setForwardLink(remediesURL);
		}

		if (isError) {
			request.getRequestDispatcher("RemediesInsert.jsp").forward(request, response);
		} else {
			remediesBean.setRemediesId(GenrateMathodsUtils.getRandomString(15));
			if (new RemediesDAO().insert(remediesBean)) {
				request.getServletContext().removeAttribute("remediesMap");
				HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
				request.getServletContext().setAttribute("remediesMap", remediesMap);
				response.sendRedirect("RemediesListServlet");
			} else {
				request.getRequestDispatcher("RemediesInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
