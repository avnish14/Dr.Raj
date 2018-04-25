package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.DAO.ProductIndicationDAO;

public class ProductIndicationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductIndicationBean> listOfProductIndication = new ProductIndicationDAO().getList();

		if (listOfProductIndication != null) {
			request.setAttribute("listOfProductIndication", listOfProductIndication);
			request.getRequestDispatcher("ProductIndicationList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("ProductIndicationList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
