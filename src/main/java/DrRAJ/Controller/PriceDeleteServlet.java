package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PriceBean;
import DrRAJ.DAO.PriceDAO;
import DrRAJ.DAO.ProductDAO;

@SuppressWarnings("serial")
public class PriceDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String priceId = request.getParameter("priceId");
		if (new PriceDAO().delete(priceId)) {
			request.getServletContext().removeAttribute("priceMap");
			HashMap<String, ArrayList<PriceBean>> priceMap = new ProductDAO().getPrice();
			request.getServletContext().setAttribute("priceMap", priceMap);
			response.sendRedirect("PriceListServlet");
		} else {
			response.sendRedirect("PriceListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
