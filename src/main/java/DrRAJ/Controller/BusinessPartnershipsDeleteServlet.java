package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.BusinessPartnershipsDAO;

/**
 * Servlet implementation class BusinessPartnershipsDeleteServlet
 */
public class BusinessPartnershipsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String businessPartnershipsId = request.getParameter("businessPartnershipsId");
		if (new BusinessPartnershipsDAO().delete(businessPartnershipsId)) {
			response.sendRedirect("BusinessParternshipsListServlet");
		} else {
			response.sendRedirect("BusinessParternshipsListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
