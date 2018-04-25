package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.CityBean;
import DrRAJ.DAO.CityDAO;

/**
 * Servlet implementation class CityListServlet
 */
public class CityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CityBean> listOfCity = new CityDAO().getList();
		if (listOfCity != null) {
			request.setAttribute("listOfCity", listOfCity);
			request.getRequestDispatcher("CityList.jsp").forward(request, response);
		} else {
		}

	}

}
