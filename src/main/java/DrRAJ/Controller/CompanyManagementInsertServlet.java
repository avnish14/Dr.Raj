package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.CompanyManagementBean;
import DrRAJ.DAO.CompanyManagementDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class CompanyManagementInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtCompanyManagementName");
		String photoLink = request.getParameter("txtPhotoLink");
		String title = request.getParameter("txtTitle");

		CompanyManagementBean companyManagementBean = new CompanyManagementBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
		} else {
			request.setAttribute("txtCompanyManagementName", name);
			companyManagementBean.setName(name);
		}

		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", "<font color=red>* Photo Link is Required</font>");
		} else {
			request.setAttribute("txtPhotoLink", photoLink);
			companyManagementBean.setPhotoLink(photoLink);
		}

		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("title", "<font color=red>* Title is Required</font>");
		} else {
			request.setAttribute("txtTitle", title);
			companyManagementBean.setTitle(title);
		}

		if (isError) {
			request.getRequestDispatcher("CompanyManagementInsert.jsp").forward(request, response);
		} else {
			companyManagementBean.setCompanyManagementId(GenrateMathodsUtils.getRandomString(15));
			if (new CompanyManagementDAO().insert(companyManagementBean)) {
				response.sendRedirect("CompanyManagementListServlet");
			} else {
				request.getRequestDispatcher("CompanyManagementInsert.jsp").forward(request, response);
			}

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
