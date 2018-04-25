package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.ProductDosageDAO;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class ProductDosageInsertServlet
 */
public class ProductDosageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dosageProductId = request.getParameter("productDosageId");
		String productId = request.getParameter("selProductName");
		String content = request.getParameter("txtContent");

		ProductDosageBean productDosageBean = new ProductDosageBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("product", "<font color=red>* Product Name is Required</font>");
		} else {
			request.setAttribute("selProductName", productId);
			productDosageBean.setProductId(productId);
		}

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", "<font color=red>* Content is Required</font>");
		} else {
			request.setAttribute("txtContent", content);
			productDosageBean.setContent(content);
		}
		productDosageBean.setProductDosageId(dosageProductId);
		if (isError) {
			productDosageBean.setContent(content);
			productDosageBean.setProductId(productId);
			productDosageBean.setProductDosageId(dosageProductId);
			request.setAttribute("productDosageBean", productDosageBean);
			request.getRequestDispatcher("ProductDosageEdit.jsp").forward(request, response);
		} else {
			productDosageBean.setProductDosageId(dosageProductId);
			if (new ProductDosageDAO().update(productDosageBean)) {
				request.getServletContext().removeAttribute("productDosageMap");
				HashMap<String, ArrayList<ProductDosageBean>> productDosageMap = new ProductDAO().getDosage();
				request.getServletContext().setAttribute("productDosageMap", productDosageMap);
				response.sendRedirect("ProductDosageListServlet");
			} else {
				request.getRequestDispatcher("ProductDosageEdit.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
