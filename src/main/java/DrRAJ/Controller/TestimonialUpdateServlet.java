package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.TestimonialBean;
import DrRAJ.DAO.TestimonialDAO;
import DrRAJ.Utils.ValidationUtils;

public class TestimonialUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtTestimonialName");
		String photoLink = request.getParameter("txtPhotoLink");
		String description = request.getParameter("txtDescription");
		String testimonialId = request.getParameter("testimonialId");

		TestimonialBean testimonialBean = new TestimonialBean();

		testimonialBean.setTestimonialId(testimonialId);
		boolean isError = false;

		
		
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
		} else {
			request.setAttribute("txtTestimonialName", name);
			testimonialBean.setName(name);
		}

		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", "<font color=red>* Photo Link is Required</font>");
		} else {
			request.setAttribute("txtPhotoLink", photoLink);
			testimonialBean.setPhotoLink(photoLink);
		}

		if (ValidationUtils.isEmpty(description)) {
			isError = true;
			request.setAttribute("description", "<font color=red>* Photo Link is Required</font>");
		} else {
			request.setAttribute("txtDescription", description);
			testimonialBean.setDescription(description);
		}

		if (isError) {
//			testimonialBean.setDescription(description);
//			testimonialBean.setName(name);
//			testimonialBean.setPhotoLink(photoLink);
//			testimonialBean.setTestimonialId(testimonialId);
			request.setAttribute("testimonialBean", testimonialBean);
			request.getRequestDispatcher("TestimonialEdit.jsp").forward(request, response);
		} else {
			if (new TestimonialDAO().update(testimonialBean)) {
				response.sendRedirect("TestimonialListServlet");
			} else {
				request.getRequestDispatcher("TestimonialEdit.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
