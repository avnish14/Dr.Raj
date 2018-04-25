package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.BusinessPartnershipsBean;
import DrRAJ.Bean.ContactUsBean;
import DrRAJ.Bean.ProductBean;
import DrRAJ.Bean.RemediesBean;
import DrRAJ.Bean.ReviewBean;
import DrRAJ.DAO.BusinessPartnershipsDAO;
import DrRAJ.DAO.ContactUsDAO;
import DrRAJ.DAO.ProductCategoryDAO;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.RemediesDAO;
import DrRAJ.DAO.ReviewDAO;
import DrRAJ.Utils.GenrateMathodsUtils;

public class AJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mName = request.getParameter("method");
		String output = "";

		if (mName.equals("reviewUpdate")) {
			output = new ReviewDAO().makeItValid(request.getParameter("reviewId"), request.getParameter("value"));
			request.getServletContext().removeAttribute("productCategoryMap");
			HashMap<String, ArrayList<ProductBean>> productCategoryMap = new ProductCategoryDAO().getCategoryMap();
			request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
			request.getServletContext().removeAttribute("productMap");
			HashMap<String, ProductBean>  productMap = new ProductDAO().getProductMap();
			request.getServletContext().setAttribute("productMap", productMap);
			request.getServletContext().removeAttribute("remediesMap");
			HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
			request.getServletContext().setAttribute("remediesMap", remediesMap);
		}
		else if (mName.equals("contactUsInsert")) {
			ContactUsBean contactUsBean = new ContactUsBean();
			String name = request.getParameter("name");
			String emailId = request.getParameter("emailId");
			String query = request.getParameter("query");
			contactUsBean.setContactUsId(GenrateMathodsUtils.getRandomString(15));
			contactUsBean.setName(name);
			contactUsBean.setEmailId(emailId);
			contactUsBean.setQuery(query);
			output = String.valueOf(new ContactUsDAO().insert(contactUsBean));
		} else if (mName.equals("businessPInsert")) {
			BusinessPartnershipsBean bean = new BusinessPartnershipsBean();
			String domain = request.getParameter("domain");
			String emailId = request.getParameter("emailId");
			String name = request.getParameter("name");
			String query = request.getParameter("query");
			String contactNumber = request.getParameter("contactNumber");

			bean.setBusinessPartnershipsId(GenrateMathodsUtils.getRandomString(15));
			bean.setName(name);
			bean.setEmailId(emailId);
			bean.setQuery(query);
			bean.setContactNumber(contactNumber);
			bean.setDomain(domain);
			output = String.valueOf(new BusinessPartnershipsDAO().insert(bean));
		} else if (mName.equals("reviewInsert")) {
			ReviewBean reviewBean = new ReviewBean();
			reviewBean.setCustomerName(request.getParameter("customerName"));
			reviewBean.setRating(Integer.parseInt(request.getParameter("rating")));
			reviewBean.setTitle(request.getParameter("title"));
			reviewBean.setDescription(request.getParameter("description"));
			reviewBean.setProductId(request.getParameter("productId"));
			reviewBean.setIsValid("0");
			reviewBean.setReviewId(GenrateMathodsUtils.getRandomString(15));
			output = String.valueOf(new ReviewDAO().insert(reviewBean));
		}

		response.setContentType("text");
		response.getWriter().write(output);

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

	public static void main(String[] args) {
		System.out.println(new ReviewDAO().makeItValid("w2yniynyIibNTbN", "1"));
	}

}
