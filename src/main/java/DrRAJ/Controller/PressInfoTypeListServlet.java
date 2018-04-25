package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoTypeBean;
import DrRAJ.DAO.PressInfoTypeDAO;

public class PressInfoTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PressInfoTypeBean> listOfPressInfoType = new PressInfoTypeDAO().getList();

		if (listOfPressInfoType != null) {
			request.setAttribute("listOfPressInfoType", listOfPressInfoType);
			request.getRequestDispatcher("PressInfoTypeList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PressInfoTypeList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
