package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.RelatedProductBean;
import DrRAJ.DAO.ReletedProductDAO;

public class ReletedProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<RelatedProductBean> relatedProductBeans = new ReletedProductDAO().getList();

		if (relatedProductBeans != null) {
			request.setAttribute("relatedProductBeans", relatedProductBeans);
			request.getRequestDispatcher("RelatedProductList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("RelatedProductList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
