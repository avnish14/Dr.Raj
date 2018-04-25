package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PriceBean;
import DrRAJ.DAO.PriceDAO;

public class PriceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PriceBean> listOfPrice = new PriceDAO().getList();

		if (listOfPrice != null) {
			request.setAttribute("listOfPrice", listOfPrice);
			request.getRequestDispatcher("PriceList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PriceList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
