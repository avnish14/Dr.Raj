package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.IngredientBean;
import DrRAJ.DAO.IngredientDAO;

public class IngredientEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ingredientId = request.getParameter("ingredientId");
		IngredientBean bean = new IngredientDAO().getByPK(ingredientId);
		if (bean != null) {
			request.setAttribute("ingreadientBean", bean);
			request.getRequestDispatcher("IngredientEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("IngredientListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
