package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PriceBean;
import DrRAJ.DAO.PriceDAO;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.Utils.ValidationUtils;

public class PriceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("txtProductId");
		String packageSize = request.getParameter("txtPackageSize");
		String txtprice = request.getParameter("txtPackagePrice");
		String priceId = request.getParameter("priceId");

		System.out.println(priceId + " " + packageSize + " " + txtprice + " " + priceId+" kjkkjh");

		PriceBean bean = new PriceBean();
		bean.setPriceId(priceId);

		boolean isError = false;

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("product", "<font color=red>* Product is Required</font>");
		} else {
			request.setAttribute("txtProductId", productId);
			bean.setProductId(productId);
		}

		if (ValidationUtils.isEmpty(packageSize)) {
			isError = true;
			request.setAttribute("packageName", "<font color=red>* Package Size is Required</font>");
			bean.setPackageSize("");
		} else {
			request.setAttribute("txtPackageSize", packageSize);
			bean.setPackageSize(packageSize);
		}

		if (ValidationUtils.isEmpty(txtprice)) {
			isError = true;
			request.setAttribute("price", "<font color=red>* Price is Required</font>");
			bean.setPrice("");
		} else {
			request.setAttribute("txtPackagePrice", txtprice);
			bean.setPrice(txtprice);
		}

		if (isError) {
			request.setAttribute("priceBean", bean);
			System.out.println(priceId + " " + packageSize + " " + txtprice + " " + priceId+ " df");
			request.getRequestDispatcher("PriceEdit.jsp").forward(request, response);
		} else {

			if (new PriceDAO().update(bean)) {
				request.getServletContext().removeAttribute("priceMap");
				HashMap<String, ArrayList<PriceBean>> priceMap = new ProductDAO().getPrice();
				request.getServletContext().setAttribute("priceMap", priceMap);
				response.sendRedirect("PriceListServlet");
			} else {
				request.getRequestDispatcher("PriceEdit.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
