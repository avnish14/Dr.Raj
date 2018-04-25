package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.CompanyManagementBean;
import DrRAJ.DAO.CompanyManagementDAO;
import DrRAJ.Utils.ValidationUtils;

public class CompanyManagementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtCompanyManagementName");
		String photoLink = request.getParameter("txtPhotoLink");
		String title = request.getParameter("txtTitle");
		String companyManagementId = request.getParameter("companyManagementId");

		CompanyManagementBean companyManagementBean = new CompanyManagementBean();

		companyManagementBean.setCompanyManagementId(companyManagementId);
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
			request.setAttribute("title", "<font color=red>* Title Link is Required</font>");
		} else {
			request.setAttribute("txtTitle", title);
			companyManagementBean.setTitle(title);
		}

		if (isError) {
			// companyManagementBean.setDescription(description);
			// companyManagementBean.setName(name);
			// companyManagementBean.setPhotoLink(photoLink);
			// companyManagementBean.setCompanyManagementId(companyManagementId);
			System.out.println("HI");
			request.setAttribute("companyManagementBean", companyManagementBean);
			request.getRequestDispatcher("CompanyManagementEdit.jsp").forward(request, response);
		} else {
			if (new CompanyManagementDAO().update(companyManagementBean)) {
				response.sendRedirect("CompanyManagementListServlet");
			} else {
				request.getRequestDispatcher("CompanyManagementEdit.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
