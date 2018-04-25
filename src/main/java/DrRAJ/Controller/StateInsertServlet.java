package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.StateBean;
import DrRAJ.DAO.StateDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class StateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stateName = request.getParameter("txtStateName");
		StateBean stateBean = new StateBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(stateName)) {
			isError = true;
			request.setAttribute("stateName", "<font color=red>* State Name is Required</font>");
		} else if (new StateDAO().isStateExists(stateName)) {
			isError = true;
			request.setAttribute("stateName", "<font color=red>* State Name is Already Exists</font>");
			request.setAttribute("txtStateName", stateName);
		} else {
			request.setAttribute("txtStateName", stateName);
			stateBean.setStateName(stateName);
		}

		if (isError) {
			request.getRequestDispatcher("StateInsert.jsp").forward(request, response);
		} else {
			stateBean.setStateId(GenrateMathodsUtils.getRandomString(15));
			if (new StateDAO().insert(stateBean)) {
				response.sendRedirect("StateListServlet");
			} else {
				request.getRequestDispatcher("StateInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
