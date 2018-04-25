package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoBean;
import DrRAJ.DAO.PressInfoDAO;

public class PressInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PressInfoBean> listOfPressInfo = new PressInfoDAO().getList();

		if (listOfPressInfo != null) {
			request.setAttribute("listOfPressInfo", listOfPressInfo);
			request.getRequestDispatcher("PressInfoList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PressInfoList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
