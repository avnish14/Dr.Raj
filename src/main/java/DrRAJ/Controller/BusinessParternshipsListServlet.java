package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BusinessPartnershipsBean;
import DrRAJ.DAO.BusinessPartnershipsDAO;

public class BusinessParternshipsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<BusinessPartnershipsBean> list = new BusinessPartnershipsDAO().getList();
		if (list != null) {
			request.setAttribute("businessPartnershipsList", list);
			request.getRequestDispatcher("BusinessPartnershipsList.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("BusinessPartnershipsList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
