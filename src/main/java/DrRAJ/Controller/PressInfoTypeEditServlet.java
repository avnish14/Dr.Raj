package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoTypeBean;
import DrRAJ.DAO.PressInfoTypeDAO;

public class PressInfoTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pressInfoTypeId = request.getParameter("pressInfoTypeId");

		PressInfoTypeBean pressInfoTypeBean = new PressInfoTypeDAO().getByPK(pressInfoTypeId);

		if (pressInfoTypeBean != null) {
			request.setAttribute("pressInfoTypeBean", pressInfoTypeBean);
			request.getRequestDispatcher("PressInfoTypeEdit.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PressInfoTypeEdit.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
