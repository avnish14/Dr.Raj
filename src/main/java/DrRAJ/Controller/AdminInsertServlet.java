package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.AdminBean;
import DrRAJ.DAO.AdminDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class AdminInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		String emailId = request.getParameter("txtEmailId");
		String password = request.getParameter("txtPassword");

		AdminBean adminBean = new AdminBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(firstName)) {
			isError = true;
			request.setAttribute("firstName", " <font color='red'> * First Name is Required </font>");
		} else {
			request.setAttribute("txtFirstName", firstName);
			adminBean.setFirstName(firstName);
		}

		if (ValidationUtils.isEmpty(lastName)) {
			isError = true;
			request.setAttribute("lastName", " <font color='red'> * Last Name is Required </font>");
		} else {
			request.setAttribute("txtLastName", lastName);
			adminBean.setLastName(lastName);
		}

		if (ValidationUtils.isEmpty(password)) {
			isError = true;
			request.setAttribute("password", " <font color='red'> * Password is Required </font>");
		} else {
			adminBean.setPassword(password);
		}

		if (ValidationUtils.isEmpty(emailId)) {
			isError = true;
			request.setAttribute("emailId", " <font color='red'> * Email Id  is Required </font>");
		} else if (!ValidationUtils.isValidEmailAddress(emailId)) {
			isError = true;
			request.setAttribute("txtEmailId", emailId);
			request.setAttribute("emailId", " <font color='red'> * Email Id  is not Valid </font>");
		} else if (new AdminDAO().isEmailExists(emailId)) {
			isError = true;
			request.setAttribute("txtEmailId", emailId);
			request.setAttribute("emailId", " <font color='red'> * Email Id  is already Exists </font>");
		} else {
			request.setAttribute("txtEmailId", emailId);
			adminBean.setEmailId(emailId);
		}

		if (isError) {
			request.getRequestDispatcher("AdminInsert.jsp").forward(request, response);
		} else {

			adminBean.setPassword(GenrateMathodsUtils.makeSHA512(password));
			adminBean.setAdminId(GenrateMathodsUtils.getRandomString(15));
			if (new AdminDAO().insert(adminBean)) {
				request.getRequestDispatcher("AdminListServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("AdminListServlet").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
