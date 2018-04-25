package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.FAQBean;
import DrRAJ.DAO.FAQDAO;
import DrRAJ.Utils.GenrateMathodsUtils;
import DrRAJ.Utils.ValidationUtils;

public class FAQInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String question = request.getParameter("txtQuestion");
		String answer = request.getParameter("txtAnswer");

		FAQBean faqBean = new FAQBean();
		boolean isError = false;
		if (ValidationUtils.isEmpty(question)) {
			isError = true;
			request.setAttribute("question", " <font color='red'> * Question is Required </font>");
		} else {
			request.setAttribute("txtQuestion", question);
			faqBean.setQuestion(question);
		}

		if (ValidationUtils.isEmpty(answer)) {
			isError = true;
			request.setAttribute("answer", " <font color='red'> * Answer is Required </font>");
		} else {
			request.setAttribute("txtAnswer", answer);
			faqBean.setAnswer(answer);
		}

		if (isError) {
			request.getRequestDispatcher("FAQInsert.jsp").forward(request, response);
		} else {
			faqBean.setFaqId(GenrateMathodsUtils.getRandomString(15));

			if (new FAQDAO().insert(faqBean)) {
				request.getRequestDispatcher("FAQListServlet").forward(request, response);

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
