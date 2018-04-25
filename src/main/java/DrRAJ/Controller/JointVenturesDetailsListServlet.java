package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class JointVenturesDetailsListServlet
 */
public class JointVenturesDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JointVenturesDetailsBean> list = (ArrayList<JointVenturesDetailsBean>) new JointVenturesDetailsDAO().getList();
		if (list != null) {
			request.getServletContext().removeAttribute("jointVenturesMap");
			HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
			request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
			request.setAttribute("jointVenturesDetailsList", list);
			request.getRequestDispatcher("JointVenturesDetailsList.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("JointVenturesDetailsList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
