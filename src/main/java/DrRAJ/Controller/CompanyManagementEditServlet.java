package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.CompanyManagementBean;
import DrRAJ.DAO.CompanyManagementDAO;

public class CompanyManagementEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String companyManagementId = request.getParameter("companyManagementId");

		CompanyManagementBean companyManagementBean = new CompanyManagementDAO().getByPK(companyManagementId);

		if (companyManagementBean != null) {
			request.setAttribute("companyManagementBean", companyManagementBean);
			request.getRequestDispatcher("CompanyManagementEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("CompanyManagementEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
