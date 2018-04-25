package DrRAJ.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.TestimonialBean;
import DrRAJ.DAO.TestimonialDAO;

public class TestimonialListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<TestimonialBean> listOfTestimonial = new TestimonialDAO().getList();

		if (listOfTestimonial != null) {
			request.setAttribute("listOfTestimonial", listOfTestimonial);
			request.getRequestDispatcher("TestimonialList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("TestimonialList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
