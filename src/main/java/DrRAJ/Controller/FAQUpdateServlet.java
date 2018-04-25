package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.FAQBean;
import DrRAJ.DAO.FAQDAO;
import DrRAJ.Utils.ValidationUtils;

public class FAQUpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("txtQuestion");
		String answer = request.getParameter("txtAnswer");
		String faqId = request.getParameter("faqId");

		FAQBean bean = new FAQBean();
		bean.setFaqId(faqId);
		// bean.setIngredientsId(ingredientId);
		// bean.setSubTitle(subTitle);

		boolean isError = false;
		if (ValidationUtils.isEmpty(question)) {
			isError = true;
			request.setAttribute("question", "<font color='red'> * Question is Required </font>");
			bean.setQuestion(" ");
		} else {
			bean.setQuestion(question);

		}

		if (ValidationUtils.isEmpty(answer)) {
			isError = true;
			bean.setAnswer(" ");
			request.setAttribute("answer", "<font color='red'> * Answer is Required </font>");
		} else {
			bean.setAnswer(answer);

		}

		if (isError) {
			request.setAttribute("faqBean", bean);
			request.getRequestDispatcher("FAQEdit.jsp").forward(request, response);
		} else {
			if (new FAQDAO().update(bean)) {
				response.sendRedirect("FAQListServlet");
			} else {
				request.getRequestDispatcher("FAQListServlet").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
