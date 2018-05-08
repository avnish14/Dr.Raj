package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.Bean.JointventuresURLDetailsBean;
import DrRAJ.DAO.JointVenturesDAO;
import DrRAJ.DAO.JointVenturesURLDetailsDAO;

/**
 * Servlet implementation class JointVenturesURLDetailsEditServlet
 */
public class JointVenturesURLDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		JointventuresURLDetailsBean bean = new JointVenturesURLDetailsDAO().getByPK(id);
		if (bean != null) {
			request.getServletContext().removeAttribute("jointVenturesMap");
			HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
			request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
			request.setAttribute("jointVenturesURLDetailsBean", bean);
			request.getRequestDispatcher("JointVenturesURLDetailsEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("JointVenturesURLDetailsListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
