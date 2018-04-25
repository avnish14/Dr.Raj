package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookBean;
import DrRAJ.DAO.BookDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class BookInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("txtBookName");
		String type = request.getParameter("txtBookType");
		String author = request.getParameter("txtBookAuthor");
		String isbn = request.getParameter("txtBookISBN");
		String description = request.getParameter("txtBookDescription");
		String photoLink = request.getParameter("txtBookPhotoLink");
		String urlLink = request.getParameter("txtBookURLLink");

		System.out.println(type + " TYPE");
		
		BookBean bean = new BookBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", " <font color='red'> * Name is Required </font>");
		} else {
			request.setAttribute("txtBookName", name);
			bean.setName(name);
		}

		if (ValidationUtils.isEmpty(type) || type.equals("0")) {
			isError = true;
			request.setAttribute("type", " <font color='red'> * Type is Required </font>");
		} else {
			request.setAttribute("txtBookType", type);
			bean.setType(type);
		}

		if (ValidationUtils.isEmpty(description)) {
			isError = true;
			request.setAttribute("description", " <font color='red'> * Discription is Required </font>");
		} else {
			request.setAttribute("txtBookDescription", description);
			bean.setDescription(description);

		}
		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", " <font color='red'> * PhotoLink is Required </font>");
		} else {
			request.setAttribute("txtBookPhotoLink", photoLink);
			bean.setPhotolink(photoLink);

		}
		if (ValidationUtils.isEmpty(urlLink)) {
			isError = true;
			request.setAttribute("URLLink", " <font color='red'> * URLLink is Required </font>");
		} else {
			request.setAttribute("txtBookURLLink", urlLink);
			bean.setUrllink(urlLink);

		}

		if (ValidationUtils.isEmpty(author)) {
			isError = true;
			request.setAttribute("author", " <font color='red'> * Author is Required </font>");
		} else {
			request.setAttribute("txtBookAuthor", author);
			bean.setAuthor(author);

		}
		if (ValidationUtils.isEmpty(isbn)) {
			isError = true;
			request.setAttribute("isbn", " <font color='red'> * ISBN is Required </font>");
		} else {
			if (new BookDAO().isbnIsExists(isbn)) {

				request.setAttribute("txtBookISBN", isbn);
				isError = true;
				request.setAttribute("isbn", " <font color='red'> * ISBN Already Exists</font>");

			} else {
				request.setAttribute("txtBookISBN", isbn);
				bean.setIsbn(isbn);
			}

		}

		if (isError) {
			request.getRequestDispatcher("BookInsert.jsp").forward(request, response);
		} else {
			bean.setBookId(GenrateMathodsUtils.getRandomString(15));
			if (new BookDAO().insert(bean)) {
				request.getServletContext().removeAttribute("bookMap");
				HashMap<String, BookBean> bookMap = new BookDAO().getBookMap();
				request.getServletContext().setAttribute("bookMap", bookMap);
				response.sendRedirect("BookListServlet");
				// request.getRequestDispatcher("IngredientListServlet").forward(request,
				// response);

			} else {
				request.getRequestDispatcher("BookInsert.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
