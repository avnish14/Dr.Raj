package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.DAO.JointVenturesDAO;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class JointVenturesUpdateServlet
 */
public class JointVenturesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("txtName");
		String imageURL = request.getParameter("txtImageURL");
		String forwardURL = request.getParameter("txtForwardURL");
		String id = request.getParameter("id");

		JointVenturesBean jointVenturesBean = new JointVenturesBean();
		jointVenturesBean.setId(id);
		boolean isError = false;
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", " <font color='red'> * Name is Required </font>");
		} else {
			request.setAttribute("txtName", name);
			jointVenturesBean.setName(name);
		}

		if (ValidationUtils.isEmpty(imageURL)) {
			isError = true;
			request.setAttribute("imageURL", " <font color='red'> * Image Link is Required </font>");
		} else {
			request.setAttribute("txtImageURL", imageURL);
			jointVenturesBean.setImageLink(imageURL);
		}

		if (ValidationUtils.isEmpty(forwardURL)) {
			isError = true;
			request.setAttribute("forwardURL", " <font color='red'> * Forward Link is Required </font>");
		} else {
			request.setAttribute("txtForwardURL", forwardURL);
			jointVenturesBean.setForwardLink(forwardURL);
		}

		if (isError) {
			request.setAttribute("jointVenturesBean", jointVenturesBean);
			request.getRequestDispatcher("JointVenturesUpdate.jsp").forward(request, response);
		} else {
			if (new JointVenturesDAO().update(jointVenturesBean)) {
				request.getServletContext().removeAttribute("jointVenturesMap");
				HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
				request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
				request.getRequestDispatcher("JointVenturesListServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("JointVenturesInsert.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
