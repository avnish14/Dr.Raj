package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.StateBean;
import DrRAJ.DAO.StateDAO;
import DrRAJ.Utils.ValidationUtils;

public class StateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stateName = request.getParameter("txtStateName");
		String stateId = request.getParameter("stateId");
		StateBean stateBean = new StateBean();

		boolean isError = false;
		System.out.println(stateName + " StateName");
		if (ValidationUtils.isEmpty(stateName)) {
			isError = true;
			request.setAttribute("stateName", "<font color=red>* State Name is Required</font>");
		} else if (new StateDAO().isStateExists(stateName)) {
			isError = true;
			request.setAttribute("stateName", "<font color=red>* State Name is Already Exists</font>");
		} else {
			request.setAttribute("txtStateName", stateName);
			stateBean.setStateName(stateName);
		}

		if (isError) {
			stateBean.setStateName(stateName);
			request.setAttribute("stateBean", stateBean);
			request.getRequestDispatcher("StateEdit.jsp").forward(request, response);
		} else {
			stateBean.setStateId(stateId);
			if (new StateDAO().update(stateBean)) {
				response.sendRedirect("StateListServlet");
			} else {
				response.sendRedirect("StateListServlet");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
