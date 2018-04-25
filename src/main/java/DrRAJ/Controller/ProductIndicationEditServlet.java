package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.DAO.ProductIndicationDAO;

public class ProductIndicationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productIndicationId = request.getParameter("productIndicationId");
		ProductIndicationBean bean = new ProductIndicationDAO().getByPK(productIndicationId);
		if (bean != null) {
			request.setAttribute("productIndicationBean", bean);
			request.getRequestDispatcher("ProductIndicationEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("ProductListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
