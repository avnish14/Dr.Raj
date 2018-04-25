package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BookBean;
import DrRAJ.DAO.BookDAO;
import DrRAJ.Utils.ValidationUtils;

@SuppressWarnings("serial")
public class BookUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("txtBookName");
		String type = request.getParameter("txtBookType");
		String author = request.getParameter("txtBookAuthor");
		String isbn = request.getParameter("txtBookISBN");
		String description = request.getParameter("txtBookDescription");
		String photoLink = request.getParameter("txtBookPhotoLink");
		String urlLink = request.getParameter("txtBookURLLink");
		String bookId = request.getParameter("bookId");

		BookBean bean = new BookBean();
		bean.setBookId(bookId);

		System.out.println(name + " " + type + " " + author);
		System.out.println(isbn + " " + description + " " + photoLink);
		System.out.println(urlLink + " " + bookId);
		boolean isError = false;
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", " <font color='red'> * Name is Required </font>");
			bean.setName("");
		} else {
			request.setAttribute("txtBookName", name);
			bean.setName(name);
		}

		if (ValidationUtils.isEmpty(type) || type.equals("0")) {
			isError = true;
			request.setAttribute("type", " <font color='red'> * Type is Required </font>");
			bean.setType("");
		} else {
			request.setAttribute("txtBookType", type);
			bean.setType(type);
		}

		if (ValidationUtils.isEmpty(description)) {
			isError = true;
			request.setAttribute("description", " <font color='red'> * Discription is Required </font>");
			bean.setDescription("");
		} else {
			request.setAttribute("txtBookDescription", description);
			bean.setDescription(description);

		}
		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", " <font color='red'> * PhotoLink is Required </font>");
			bean.setPhotolink("");
		} else {
			request.setAttribute("txtBookPhotoLink", photoLink);
			bean.setPhotolink(photoLink);

		}
		if (ValidationUtils.isEmpty(urlLink)) {
			isError = true;
			request.setAttribute("URLLink", " <font color='red'> * URLLink is Required </font>");
			bean.setUrllink("");
		} else {
			request.setAttribute("txtBookURLLink", urlLink);
			bean.setUrllink(urlLink);

		}

		if (ValidationUtils.isEmpty(author)) {
			isError = true;
			request.setAttribute("author", " <font color='red'> * Author is Required </font>");
			bean.setAuthor("");
		} else {
			request.setAttribute("txtBookAuthor", author);
			bean.setAuthor(author);

		}
		if (ValidationUtils.isEmpty(isbn)) {
			isError = true;
			request.setAttribute("isbn", " <font color='red'> * ISBN is Required </font>");
			bean.setIsbn("");
		} else {
			if (new BookDAO().isbnIsExists(isbn) && !(new BookDAO().getByPK(bookId)).getIsbn().equalsIgnoreCase(isbn)) {
				request.setAttribute("txtBookISBN", isbn);
				isError = true;
				request.setAttribute("isbn", " <font color='red'> * ISBN Already Exists</font>");
				bean.setIsbn(isbn);

			} else {
				request.setAttribute("txtBookISBN", isbn);
				bean.setIsbn(isbn);
			}

		}

		if (isError) {
			System.out.println("csndlnk");
			request.setAttribute("bookBean", bean);
			request.getRequestDispatcher("BookEdit.jsp").forward(request, response);
		} else {
			if (new BookDAO().update(bean)) {
				request.getServletContext().removeAttribute("bookMap");
				HashMap<String, BookBean> bookMap = new BookDAO().getBookMap();
				request.getServletContext().setAttribute("bookMap", bookMap);
				response.sendRedirect("BookListServlet");
			} else {
				request.getRequestDispatcher("BookEdit.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
