package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.StoreDetailsBean;
import DrRAJ.DAO.StoreDetailsDAO;

public class StoreDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<StoreDetailsBean> listOfStores = new StoreDetailsDAO().getList();

		if (listOfStores != null) {
			request.setAttribute("listOfStores", listOfStores);
			request.getRequestDispatcher("StoreDetailsList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("StoreDetailsList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
