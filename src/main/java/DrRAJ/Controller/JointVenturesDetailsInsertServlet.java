package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.Bean.JointVenturesDetailsBean;
import DrRAJ.DAO.JointVenturesDAO;
import DrRAJ.DAO.JointVenturesDetailsDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class JointVenturesDetailsInsertServlet
 */
public class JointVenturesDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("txtTitle");
		String imageURL = request.getParameter("txtImageURL");
		String content = request.getParameter("txtContent");
		String jointVenturesId = request.getParameter("txtJointVentures");

		JointVenturesDetailsBean jointVenturesDetailsBean = new JointVenturesDetailsBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(title)) {
			isError = true;
			request.setAttribute("title", " <font color='red'> * Title is Required </font>");
		} else {
			request.setAttribute("txtTitle", title);
			jointVenturesDetailsBean.setTitle(title);
		}

		if (ValidationUtils.isEmpty(imageURL)) {
			isError = true;
			request.setAttribute("imageURL", " <font color='red'> * Image Link is Required </font>");
		} else {
			request.setAttribute("txtImageURL", imageURL);
			jointVenturesDetailsBean.setImageLink(imageURL);
		}

		if (jointVenturesId.equals("0")) {
			request.setAttribute("jointVenture", " <font color='red'> * Joint Ventures Name is Required </font>");
		} else {
			request.setAttribute("txtJointVentures", jointVenturesId);
			jointVenturesDetailsBean.setJointVenturesId(jointVenturesId);
		}

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", " <font color='red'> * Content  is Required </font>");
		} else {
			request.setAttribute("txtContent", content);
			jointVenturesDetailsBean.setContent(content);
		}

		if (isError) {
			request.getRequestDispatcher("JointVenturesDetailsInsert.jsp").forward(request, response);
		} else {
			jointVenturesDetailsBean.setId(GenrateMathodsUtils.getRandomString(15));
			if (new JointVenturesDetailsDAO().insert(jointVenturesDetailsBean)) {
				request.getServletContext().removeAttribute("jointVenturesMap");
				HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
				request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
				request.getRequestDispatcher("JointVenturesDetailsListServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("JointVenturesDetailsInsert.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
