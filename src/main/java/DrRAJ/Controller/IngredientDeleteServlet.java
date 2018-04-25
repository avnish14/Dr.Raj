package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.IngredientBean;
import DrRAJ.DAO.IngredientDAO;
import DrRAJ.DAO.ProductDAO;

public class IngredientDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ingredientId = request.getParameter("ingredientId");
		if (new IngredientDAO().delete(ingredientId)) {
			request.getServletContext().removeAttribute("ingredientMap");
			HashMap<String, ArrayList<IngredientBean>> ingredientMap = new ProductDAO().getIngredient();
			request.getServletContext().setAttribute("ingredientMap", ingredientMap);
			response.sendRedirect("IngredientListServlet");
		} else {
			response.sendRedirect("IngredientListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
