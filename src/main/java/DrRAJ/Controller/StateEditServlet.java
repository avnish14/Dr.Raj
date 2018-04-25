package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.StateBean;
import DrRAJ.DAO.StateDAO;

public class StateEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stateId = request.getParameter("stateId");

		StateBean stateBean = new StateDAO().getByPK(stateId);

		if (stateBean != null) {
			request.setAttribute("stateBean", stateBean);
			request.getRequestDispatcher("StateEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("StateEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
