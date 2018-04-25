package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductCompositionBean;
import DrRAJ.DAO.ProductCompositionDAO;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class ProductCompositionInsertServlet
 */
public class ProductCompositionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dosageProductId = request.getParameter("productCompositionId");
		String productId = request.getParameter("selProductName");
		String content = request.getParameter("txtContent");
		String ingredientId = request.getParameter("selIngredientName");

		ProductCompositionBean productCompositionBean = new ProductCompositionBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(productId) || productId.equals("0")) {
			isError = true;
			request.setAttribute("product", "<font color=red>* Product Name is Required</font>");
		} else {
			request.setAttribute("selProductName", productId);
			productCompositionBean.setProductId(productId);
		}

		if (ValidationUtils.isEmpty(ingredientId) || ingredientId.equals("0")) {
			isError = true;
			request.setAttribute("ingredients", "<font color=red>* Ingredients Name is Required</font>");
		} else {
			request.setAttribute("selIngredientName", productId);
			productCompositionBean.setIngredientsId(ingredientId);
		}

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", "<font color=red>* Content is Required</font>");
		} else {
			request.setAttribute("txtContent", content);
			productCompositionBean.setCompositionContent(content);
		}
		productCompositionBean.setProductCompositionId(dosageProductId);
		if (isError) {
			productCompositionBean.setIngredientsId(ingredientId);
			productCompositionBean.setCompositionContent(content);
			productCompositionBean.setProductId(productId);
			productCompositionBean.setProductCompositionId(dosageProductId);
			request.setAttribute("productCompositionBean", productCompositionBean);
			request.getRequestDispatcher("ProductCompositionEdit.jsp").forward(request, response);
		} else {
			productCompositionBean.setProductCompositionId(dosageProductId);
			if (new ProductCompositionDAO().update(productCompositionBean)) {
				request.getServletContext().removeAttribute("productCompositionMap");
				HashMap<String, ArrayList<ProductCompositionBean>> productCompositionMap = new ProductDAO()
						.getComposition();
				request.getServletContext().setAttribute("productCompositionMap", productCompositionMap);
				response.sendRedirect("ProductCompositionListServlet");
			} else {
				request.getRequestDispatcher("ProductCompositionEdit.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
