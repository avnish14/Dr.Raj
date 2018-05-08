package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.PressInfoTypeBean;
import DrRAJ.DAO.PressInfoTypeDAO;
import DrRAJ.Utils.ValidationUtils;

public class PressInfoTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pressInfoTypeName = request.getParameter("txtPressInfoTypeName");
		String pressInfoTypeId = request.getParameter("pressInfoTypeId");
		PressInfoTypeBean pressInfoTypeBean = new PressInfoTypeBean();

		boolean isError = false;
		if (ValidationUtils.isEmpty(pressInfoTypeName)) {
			isError = true;
			request.setAttribute("pressInfoTypeName", "<font color=red>* PressInfoType Name is Required</font>");
		} else if (new PressInfoTypeDAO().isPressInfoTypeExists(pressInfoTypeName)) {
			isError = true;
			request.setAttribute("pressInfoTypeName", "<font color=red>* PressInfoType Name is Already Exists</font>");
		} else {
			request.setAttribute("txtPressInfoTypeName", pressInfoTypeName);
			pressInfoTypeBean.setName(pressInfoTypeName);
		}

		if (isError) {
			pressInfoTypeBean.setName(pressInfoTypeName);
			request.setAttribute("pressInfoTypeBean", pressInfoTypeBean);
			request.getRequestDispatcher("PressInfoTypeEdit.jsp").forward(request, response);
		} else {
			pressInfoTypeBean.setTypeId(pressInfoTypeId);
			if (new PressInfoTypeDAO().update(pressInfoTypeBean)) {
				response.sendRedirect("PressInfoTypeListServlet");
			} else {
				response.sendRedirect("PressInfoTypeListServlet");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
