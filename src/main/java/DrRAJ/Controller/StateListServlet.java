package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.StateBean;
import DrRAJ.DAO.StateDAO;

public class StateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<StateBean> listOfState = new StateDAO().getList();

		if (listOfState != null) {
			request.setAttribute("listOfState", listOfState);
			request.getRequestDispatcher("StateList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("StateList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
