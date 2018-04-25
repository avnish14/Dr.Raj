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
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class IngredientInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("txtIngredientTitle");
		String description = request.getParameter("txtIngredientDescription");
		String photoLink = request.getParameter("txtIngredientPhotoLink");

		IngredientBean bean = new IngredientBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("ingredientTitle", " <font color='red'> * Title is Required </font>");
		} else {
			request.setAttribute("txtIngredientTitle", title);
			bean.setTitle(title);
		}

		if (ValidationUtils.isEmpty(description)) {
			isError = true;
			request.setAttribute("ingredientDescription", " <font color='red'> * Discription is Required </font>");
		} else {
			request.setAttribute("txtIngredientDescription", description);
			bean.setDescription(description);

		}
		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("ingredientPhotoLink", " <font color='red'> * PhotoLink is Required </font>");
		} else {
			request.setAttribute("txtIngredientPhotoLink", photoLink);
			bean.setPhotoLink(photoLink);

		}
		

		if (isError) {
			request.getRequestDispatcher("IngredientInsert.jsp").forward(request, response);
		} else {
			bean.setIngredientsId(GenrateMathodsUtils.getRandomString(15));
			if (new IngredientDAO().insert(bean)) {
				request.getServletContext().removeAttribute("ingredientMap");
				HashMap<String, ArrayList<IngredientBean>> ingredientMap = new ProductDAO().getIngredient();
				request.getServletContext().setAttribute("ingredientMap", ingredientMap);
				response.sendRedirect("IngredientListServlet");
				// request.getRequestDispatcher("IngredientListServlet").forward(request,
				// response);

			} else {
				request.getRequestDispatcher("IngredientInsert.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
