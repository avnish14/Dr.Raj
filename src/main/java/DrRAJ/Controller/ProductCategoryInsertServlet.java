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
import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.ProductCategoryDAO;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.RemediesDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class ProductCategoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCategoryName = request.getParameter("txtProductCategoryName");
		String productCategoryURL = request.getParameter("txtProductCategoryURL");
		ProductCategoryBean productCategoryBean = new ProductCategoryBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(productCategoryName)) {
			isError = true;
			request.setAttribute("productCategoryName", "<font color=red>* ProductCategory Name is Required</font>");
		} else if (new ProductCategoryDAO().isProductCategoryExists(productCategoryName)) {
			isError = true;
			request.setAttribute("productCategoryName", "<font color=red>* ProductCategory Name is Already Exists</font>");
			request.setAttribute("txtProductCategoryName", productCategoryName);
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
			request.getRequestDispatcher("ProductCategoryInsert.jsp").forward(request, response);
		} else {
			productCategoryBean.setProductCategoryId(GenrateMathodsUtils.getRandomString(15));
			if (new ProductCategoryDAO().insert(productCategoryBean)) {
				request.getServletContext().removeAttribute("productCategoryMap");
				HashMap<String, ArrayList<ProductBean>> productCategoryMap = new ProductCategoryDAO().getCategoryMap();
				request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
				request.getServletContext().removeAttribute("productMap");
				HashMap<String, ProductBean>  productMap = new ProductDAO().getProductMap();
				request.getServletContext().setAttribute("productMap", productMap);
				request.getServletContext().removeAttribute("remediesMap");
				HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
				request.getServletContext().setAttribute("remediesMap", remediesMap);
				response.sendRedirect("ProductCategoryListServlet");
			} else {
				request.getRequestDispatcher("ProductCategoryInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
