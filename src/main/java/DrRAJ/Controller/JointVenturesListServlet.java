package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.DAO.JointVenturesDAO;

/**
 * Servlet implementation class JointVenturesListServlet
 */
public class JointVenturesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JointVenturesBean> list = (ArrayList<JointVenturesBean>) new JointVenturesDAO().getList();
		if (list != null) {
			request.getServletContext().removeAttribute("jointVenturesMap");
			HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
			request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
			request.setAttribute("jointVenturesList", list);
			request.getRequestDispatcher("JointVenturesList.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("JointVenturesList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
