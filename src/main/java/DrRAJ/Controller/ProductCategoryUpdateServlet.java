package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductBean;
import DrRAJ.Bean.ProductCategoryBean;
import DrRAJ.DAO.ProductCategoryDAO;
import DrRAJ.Utils.ValidationUtils;

public class ProductCategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCategoryName = request.getParameter("txtProductCategoryName");
		String productCategoryURL = request.getParameter("txtProductCategoryURL");
		String productCategoryId = request.getParameter("productCategoryId");
		ProductCategoryBean productCategoryBean = new ProductCategoryBean();

		boolean isError = false;
		if (ValidationUtils.isEmpty(productCategoryName)) {
			isError = true;
			request.setAttribute("productCategoryName", "<font color=red>* ProductCategory Name is Required</font>");
		} else {
			request.setAttribute("txtProductCategoryName", productCategoryName);
			productCategoryBean.setProductCategoryName(productCategoryName);
		}

		if (ValidationUtils.isEmpty(productCategoryURL)) {
			isError = true;
			request.setAttribute("productCategoryURL", "<font color=red>* Product Category URL is Required</font>");
		} else {
			request.setAttribute("txtProductCategoryURL", productCategoryURL);
			productCategoryBean.setForwardLink(productCategoryURL);
		}

		if (isError) {
			productCategoryBean.setProductCategoryName(productCategoryName);
			productCategoryBean.setForwardLink(productCategoryURL);
			request.setAttribute("productCategoryBean", productCategoryBean);
			request.getRequestDispatcher("ProductCategoryEdit.jsp").forward(request, response);
		} else {
			productCategoryBean.setProductCategoryId(productCategoryId);
			if (new ProductCategoryDAO().update(productCategoryBean)) {
				request.getServletContext().removeAttribute("productCategoryMap");
				HashMap<String, ArrayList<ProductBean>> productCategoryMap = new ProductCategoryDAO().getCategoryMap();
				request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
				
				response.sendRedirect("ProductCategoryListServlet");
			} else {
				response.sendRedirect("ProductCategoryListServlet");
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
