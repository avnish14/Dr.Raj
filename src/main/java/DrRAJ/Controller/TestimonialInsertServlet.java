package DrRAJ.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.TestimonialBean;
import DrRAJ.DAO.TestimonialDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class TestimonialInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtTestimonialName");
		String photoLink = request.getParameter("txtPhotoLink");
		String description = request.getParameter("txtDescription");

		TestimonialBean testimonialBean = new TestimonialBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
		} else if (new TestimonialDAO().isTestimonialExists(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Already Exists</font>");
			request.setAttribute("txtTestimonialName", name);
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
			request.getRequestDispatcher("TestimonialInsert.jsp").forward(request, response);
		} else {
			testimonialBean.setTestimonialId(GenrateMathodsUtils.getRandomString(15));
			if (new TestimonialDAO().insert(testimonialBean)) {
				response.sendRedirect("TestimonialListServlet");
			} else {
				request.getRequestDispatcher("TestimonialInsert.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
