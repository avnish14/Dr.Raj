package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.DAO.ProductDosageDAO;

public class ProductDosageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productDosageId = request.getParameter("productDosageId");
		ProductDosageBean bean = new ProductDosageDAO().getByPK(productDosageId);
		if (bean != null) {
			request.setAttribute("productDosageBean", bean);
			request.getRequestDispatcher("ProductDosageEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("ProductDosageListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
