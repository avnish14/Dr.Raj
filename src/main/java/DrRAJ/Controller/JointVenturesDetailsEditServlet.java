package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.Bean.JointVenturesDetailsBean;
import DrRAJ.DAO.JointVenturesDAO;
import DrRAJ.DAO.JointVenturesDetailsDAO;

/**
 * Servlet implementation class JointVenturesDetailsEditServlet
 */
public class JointVenturesDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("Hi.............");
		JointVenturesDetailsBean bean = new JointVenturesDetailsDAO().getByPK(id);
		if (bean != null) {
			request.getServletContext().removeAttribute("jointVenturesMap");
			HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
			request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
			request.setAttribute("jointVenturesDetailsBean", bean);
			request.getRequestDispatcher("JointVenturesDetailsEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("JointVenturesDetailsListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
