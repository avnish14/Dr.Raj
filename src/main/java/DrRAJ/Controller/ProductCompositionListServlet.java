package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductCompositionBean;
import DrRAJ.DAO.ProductCompositionDAO;

public class ProductCompositionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductCompositionBean> listOfProductComposition = new ProductCompositionDAO().getList();
		System.out.println(listOfProductComposition.size());
		if (listOfProductComposition != null) {
			request.setAttribute("listOfProductComposition", listOfProductComposition);
			request.getRequestDispatcher("ProductCompositionList.jsp").forward(request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
