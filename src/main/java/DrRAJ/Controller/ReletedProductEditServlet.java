package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RelatedProductBean;
import DrRAJ.DAO.ReletedProductDAO;

public class ReletedProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String relatedProductId = request.getParameter("relatedProductId");
		RelatedProductBean relatedProductBean = new ReletedProductDAO().getByPK(relatedProductId);
		if (relatedProductBean != null) {
			request.setAttribute("relatedProductBean", relatedProductBean);
			request.getRequestDispatcher("RelatedProductEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("ReletedProductListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
