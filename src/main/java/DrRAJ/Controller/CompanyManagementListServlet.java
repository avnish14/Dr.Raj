package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.CompanyManagementBean;
import DrRAJ.DAO.CompanyManagementDAO;

public class CompanyManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CompanyManagementBean> listOfCompanyManagement = new CompanyManagementDAO().getList();

		if (listOfCompanyManagement != null) {
			request.setAttribute("listOfCompanyManagement", listOfCompanyManagement);
			request.getRequestDispatcher("CompanyManagementList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("CompanyManagementList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
