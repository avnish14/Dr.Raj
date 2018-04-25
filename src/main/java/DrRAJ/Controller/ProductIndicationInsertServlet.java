package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.ProductIndicationDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class ProductIndicationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("txtProductId");
		String productIndication = request.getParameter("txtProductIndication");

		ProductIndicationBean bean = new ProductIndicationBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("product", "<font color=red>* Product is Required</font>");
		} else {
			request.setAttribute("txtProductId", productId);
			bean.setProductId(productId);
		}

		if (ValidationUtils.isEmpty(productIndication)) {
			isError = true;
			request.setAttribute("indication", "<font color=red>* Product Indication is Required</font>");
		} else {
			request.setAttribute("txtProductIndication", productIndication);
			bean.setIndication(productIndication);
		}

		if (isError) {
			request.getRequestDispatcher("ProductIndicationInsert.jsp").forward(request, response);
		} else {

			bean.setProductIndicationId(GenrateMathodsUtils.getRandomString(15));
			if (new ProductIndicationDAO().insert(bean)) {
				request.getServletContext().removeAttribute("productIndicationMap");
				HashMap<String, ArrayList<ProductIndicationBean>> productIndicationMap = new ProductDAO().getIndication();
				request.getServletContext().setAttribute("productIndicationMap", productIndicationMap);
				response.sendRedirect("ProductIndicationListServlet");
			} else {
				request.getRequestDispatcher("ProductIndicationInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
