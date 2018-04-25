package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PriceBean;
import DrRAJ.DAO.PriceDAO;

public class PriceEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String priceId = request.getParameter("priceId");
		PriceBean bean = new PriceDAO().getByPK(priceId);
		if (bean != null) {
			request.setAttribute("priceBean", bean);
			request.getRequestDispatcher("PriceEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("PriceListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
