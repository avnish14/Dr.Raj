package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.DAO.ProductDosageDAO;

public class ProductDosageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductDosageBean> listOfProductDosage = new ProductDosageDAO().getList();
		System.out.println(listOfProductDosage.size());
		if (listOfProductDosage != null) {
			request.setAttribute("listOfProductDosage", listOfProductDosage);
			request.getRequestDispatcher("ProductDosageList.jsp").forward(request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
