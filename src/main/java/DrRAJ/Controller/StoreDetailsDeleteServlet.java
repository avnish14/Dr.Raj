package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.DAO.StoreDetailsDAO;

@SuppressWarnings("serial")
public class StoreDetailsDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String storeId = request.getParameter("storeId");
		if (new StoreDetailsDAO().delete(storeId)) {
			response.sendRedirect("StoreDetailsListServlet");
		} else {
			response.sendRedirect("StoreDetailsListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
