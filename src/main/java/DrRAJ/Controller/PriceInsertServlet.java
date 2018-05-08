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
import DrRAJ.Utils.ValidationUtils;

public class PriceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("txtProductId");
		String packageSize = request.getParameter("txtDummy");


		boolean isError = false;

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("product", "<font color=red>* Product is Required</font>");
		} else {
			request.setAttribute("txtProductId", productId);
		}

		if (isError) {
			request.getRequestDispatcher("PriceInsert.jsp").forward(request, response);
		} else {
			if (new PriceDAO().insert(packageSize,productId)) {
				request.getServletContext().removeAttribute("priceMap");
				HashMap<String, ArrayList<PriceBean>> priceMap = new ProductDAO().getPrice();
				request.getServletContext().setAttribute("priceMap", priceMap);
				response.sendRedirect("PriceListServlet");
			} else {
				request.getRequestDispatcher("PriceInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
