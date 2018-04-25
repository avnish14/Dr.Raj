package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class JointVenturesURLDetailsListServlet
 */
public class JointVenturesURLDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JointventuresURLDetailsBean> list = (ArrayList<JointventuresURLDetailsBean>) new JointVenturesURLDetailsDAO()
				.getList();
		if (list != null) {
			request.getServletContext().removeAttribute("jointVenturesMap");
			HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
			request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
			request.setAttribute("jointVenturesURLDetailsList", list);
			request.getRequestDispatcher("JointVenturesURLDetailsList.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("JointVenturesURLDetailsList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
