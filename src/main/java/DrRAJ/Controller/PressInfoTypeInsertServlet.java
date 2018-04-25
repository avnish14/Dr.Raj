package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoTypeBean;
import DrRAJ.DAO.PressInfoTypeDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class PressInfoTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pressInfoTypeName = request.getParameter("txtPressInfoTypeName");
		PressInfoTypeBean pressInfoTypeBean = new PressInfoTypeBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(pressInfoTypeName)) {
			isError = true;
			request.setAttribute("pressInfoTypeName", "<font color=red>* PressInfoType Name is Required</font>");
		} else if (new PressInfoTypeDAO().isPressInfoTypeExists(pressInfoTypeName)) {
			isError = true;
			request.setAttribute("pressInfoTypeName", "<font color=red>* PressInfoType Name is Already Exists</font>");
			request.setAttribute("txtPressInfoTypeName", pressInfoTypeName);
		} else {
			request.setAttribute("txtPressInfoTypeName", pressInfoTypeName);
			pressInfoTypeBean.setName(pressInfoTypeName);
		}

		if (isError) {
			request.getRequestDispatcher("PressInfoTypeInsert.jsp").forward(request, response);
		} else {
			pressInfoTypeBean.setTypeId(GenrateMathodsUtils.getRandomString(15));
			if (new PressInfoTypeDAO().insert(pressInfoTypeBean)) {
				response.sendRedirect("PressInfoTypeListServlet");
			} else {
				request.getRequestDispatcher("PressInfoTypeInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
