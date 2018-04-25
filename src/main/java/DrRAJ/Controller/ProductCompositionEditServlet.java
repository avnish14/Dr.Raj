package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductCompositionBean;
import DrRAJ.DAO.ProductCompositionDAO;

public class ProductCompositionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCompositionId = request.getParameter("productCompositionId");
		ProductCompositionBean bean = new ProductCompositionDAO().getByPK(productCompositionId);
		if (bean != null) {
			request.setAttribute("productCompositionBean", bean);
			request.getRequestDispatcher("ProductCompositionEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("ProductCompositionListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
