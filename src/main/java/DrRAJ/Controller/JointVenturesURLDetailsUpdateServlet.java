package DrRAJ.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.Bean.JointventuresURLDetailsBean;
import DrRAJ.DAO.JointVenturesDAO;
import DrRAJ.DAO.JointVenturesURLDetailsDAO;
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class JointVenturesURLDetailsDetailsUpdateServlet
 */
public class JointVenturesURLDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String subSubTitle = request.getParameter("txtSubTitle");
		String pdfLink = request.getParameter("txtPdfLink");
		String pdfName = request.getParameter("txtPdfName");
		String content = request.getParameter("txtContent");
		String jointVenturesId = request.getParameter("jointVenturesId");
		String id = request.getParameter("id");
		System.out.println("Helloooooooooo");

		System.out.println("jointVenturesId " + jointVenturesId);

		JointventuresURLDetailsBean jointVenturesURLDetailsBean = new JointventuresURLDetailsBean();
		jointVenturesURLDetailsBean.setId(id);
		boolean isError = false;

		if (ValidationUtils.isEmpty(subSubTitle)) {
			isError = true;
			request.setAttribute("subSubTitle", " <font color='red'> * SubTitle is Required </font>");
		} else {
			request.setAttribute("txtSubTitle", subSubTitle);
			jointVenturesURLDetailsBean.setSubTitle(subSubTitle);
		}

		if (ValidationUtils.isEmpty(pdfName)) {
			isError = true;
			request.setAttribute("pdfName", " <font color='red'> * PDF Name is Required </font>");
		} else {
			request.setAttribute("txtPdfName", pdfName);
			jointVenturesURLDetailsBean.setPdfName(pdfName);
		}

		if (ValidationUtils.isEmpty(pdfLink)) {
			isError = true;
			request.setAttribute("pdfLink", " <font color='red'> * PDF Link is Required </font>");
		} else {
			request.setAttribute("txtPdfLink", pdfLink);
			jointVenturesURLDetailsBean.setPdfLink(pdfLink);
		}

		if (jointVenturesId.length() == 0 || jointVenturesId.equals("0") || jointVenturesId == null) {
			isError = true;
			request.setAttribute("jointVenture", " <font color='red'> * Joint Ventures Name is Required </font>");
		} else {
			request.setAttribute("jointVenturesId", jointVenturesId);
			jointVenturesURLDetailsBean.setJointVenturesId(jointVenturesId);
		}

		if (ValidationUtils.isEmpty(content)) {
			isError = true;
			request.setAttribute("content", " <font color='red'> * Content is Required </font>");
		} else {
			request.setAttribute("txtContent", content);
			jointVenturesURLDetailsBean.setContent(content);
		}

		if (isError) {
			System.out.println("hiiiiiiii");
			request.setAttribute("jointVenturesURLDetailsBean", jointVenturesURLDetailsBean);
			request.getRequestDispatcher("JointVenturesURLDetailsEdit.jsp").forward(request, response);
		} else {
			System.out.println("Hello");
			if (new JointVenturesURLDetailsDAO().update(jointVenturesURLDetailsBean)) {
				request.getServletContext().removeAttribute("jointVenturesMap");
				HashMap<String, JointVenturesBean> jointVenturesMap = new JointVenturesDAO().getListMap();
				request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
				request.getRequestDispatcher("JointVenturesURLDetailsListServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("JointVenturesURLDetailsEdit.jsp").forward(request, response);
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
