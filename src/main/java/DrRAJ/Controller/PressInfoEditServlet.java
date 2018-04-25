package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoBean;
import DrRAJ.DAO.PressInfoDAO;

public class PressInfoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pressInfoId = request.getParameter("pressInfoId");

		PressInfoBean pressInfoBean = new PressInfoDAO().getByPK(pressInfoId);

		if (pressInfoBean != null) {
			request.setAttribute("pressInfoBean", pressInfoBean);
			request.getRequestDispatcher("PressInfoEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PressInfoEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
