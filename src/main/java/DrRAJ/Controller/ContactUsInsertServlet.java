package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ContactUsBean;
import DrRAJ.DAO.ContactUsDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class ContactUsInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtName");
		String emailId = request.getParameter("txtEmailId");
		String query = request.getParameter("txtQuery");

		ContactUsBean contactUsBean = new ContactUsBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", " <font color='red'> *Name is Required </font>");
		} else {
			request.setAttribute("txtName", name);
			contactUsBean.setName(name);
		}

		if (ValidationUtils.isEmpty(emailId)) {
			isError = true;
			request.setAttribute("emailId", " <font color='red'> * Email Id  is Required </font>");
		} else if (!ValidationUtils.isValidEmailAddress(emailId)) {
			isError = true;
			request.setAttribute("txtEmailId", emailId);
			request.setAttribute("emailId", " <font color='red'> * Email Id  is not Valid </font>");
		} else {
			request.setAttribute("txtEmailId", emailId);
			contactUsBean.setEmailId(emailId);
		}

		if (ValidationUtils.isEmpty(query)) {
			isError = true;
			request.setAttribute("txtQuery", query);
			request.setAttribute("query", " <font color='red'> * Query is Required </font>");
		} else {
			request.setAttribute("txtQuery", query);
			contactUsBean.setQuery(query);
		}

		if (isError) {
			request.setAttribute("result", "0");
			request.getRequestDispatcher("homoeopathic-consultancy").forward(request, response);
		} else {

			contactUsBean.setContactUsId(GenrateMathodsUtils.getRandomString(15));
			if (new ContactUsDAO().insert(contactUsBean)) {
				request.setAttribute("result", "1");
				request.getRequestDispatcher("homoeopathic-consultancy").forward(request, response);
			} else {
				request.setAttribute("result", "0");
				request.getRequestDispatcher("homoeopathic-consultancy").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
