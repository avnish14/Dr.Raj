package DrRAJ.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.ProductBean;
import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.ProductCategoryDAO;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.RemediesDAO;
import DrRAJ.DAO.ReviewDAO;

public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reviewId = request.getParameter("reviewId");
		if (new ReviewDAO().delete(reviewId)) {
			request.getServletContext().removeAttribute("productCategoryMap");
			HashMap<String, ArrayList<ProductBean>> productCategoryMap = new ProductCategoryDAO().getCategoryMap();
			request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
			request.getServletContext().removeAttribute("productMap");
			HashMap<String, ProductBean>  productMap = new ProductDAO().getProductMap();
			request.getServletContext().setAttribute("productMap", productMap);
			request.getServletContext().removeAttribute("remediesMap");
			HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
			request.getServletContext().setAttribute("remediesMap", remediesMap);
			response.sendRedirect("ReviewListServlet");
		} else {
			request.getServletContext().removeAttribute("productCategoryMap");
			HashMap<String, ArrayList<ProductBean>> productCategoryMap = new ProductCategoryDAO().getCategoryMap();
			request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
			request.getServletContext().removeAttribute("productMap");
			HashMap<String, ProductBean>  productMap = new ProductDAO().getProductMap();
			request.getServletContext().setAttribute("productMap", productMap);
			request.getServletContext().removeAttribute("remediesMap");
			HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
			request.getServletContext().setAttribute("remediesMap", remediesMap);
			response.sendRedirect("ReviewListServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
