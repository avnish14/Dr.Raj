package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.CityBean;
import DrRAJ.DAO.CityDAO;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class CityUpdateServlet
 */
public class CityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cityName = request.getParameter("txtCityName");
		String stateName = request.getParameter("selStateName");
		CityBean cityBean = new CityBean();

		cityBean.setCityId(request.getParameter("cityId"));
		boolean isError = false;

		if (ValidationUtils.isEmpty(cityName)) {
			isError = true;
			request.setAttribute("cityName", "<font color=red>* City Name is Required</font>");
		} else {
			request.setAttribute("txtCityName", cityName);
			cityBean.setCityName(cityName);
		}
		if (stateName.equals("0")) {
			isError = true;
			request.setAttribute("stateName", "<font color=red>* State Name is Required</font>");
		} else {
			request.setAttribute("selStateName", stateName);
			cityBean.setStateId(stateName);
		}

		if (isError) {
			cityBean.setCityName(cityName);
			cityBean.setStateName(stateName);
			request.setAttribute("cityBean", cityBean);
			request.getRequestDispatcher("CityEdit.jsp").forward(request, response);
		} else {
			if (new CityDAO().update(cityBean)) {
				response.sendRedirect("CityListServlet");
			} else {
				response.sendRedirect("CityListServlet");
			}

		}
	}

}