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
import DrRAJ.Utils.ValidationUtils;

/**
 * Servlet implementation class ProductInsertServlet
 */
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("txtProductName");
		String photoLink = request.getParameter("txtPhotoLink");
		String forwardLink = request.getParameter("txtForwardLink");
		String interaction = request.getParameter("txtInteraction");
		String sideEffect = request.getParameter("txtSideEffect");
		String contraIndication = request.getParameter("txtContraIndication");
		String purpose = request.getParameter("txtPurpose");
		String description = request.getParameter("txtDescription");
		String selRemedies = request.getParameter("selRemedies");
		String selProductCategoryName = request.getParameter("selProductCategoryName");
		String productId = request.getParameter("productId");
		String productURL = request.getParameter("txtProductURL");
		ProductBean productBean = new ProductBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
		} else {
			request.setAttribute("txtProductName", name);
			productBean.setProductName(name);
		}

		if (ValidationUtils.isEmpty(photoLink)) {
			isError = true;
			request.setAttribute("photoLink", "<font color=red>* Photo Link is Required</font>");
		} else {
			request.setAttribute("txtPhotoLink", photoLink);
			productBean.setImageLink(photoLink);
		}

		if (ValidationUtils.isEmpty(forwardLink)) {
			isError = true;
			request.setAttribute("forwardLink", "<font color=red>* ForwardLink is Required</font>");
		} else {
			request.setAttribute("txtForwardLink", forwardLink);
			productBean.setForwardLink(forwardLink);
		}

		if (ValidationUtils.isEmpty(interaction)) {
			isError = true;
			request.setAttribute("interaction", "<font color=red>* Interaction is Required</font>");
		} else {
			request.setAttribute("txtInteraction", interaction);
			productBean.setInteraction(interaction);
		}

		if (ValidationUtils.isEmpty(sideEffect)) {
			isError = true;
			request.setAttribute("sideEffect", "<font color=red>* SideEffect is Required</font>");
		} else {
			request.setAttribute("txtSideEffect", sideEffect);
			productBean.setSideEffect(sideEffect);
		}

		if (ValidationUtils.isEmpty(contraIndication)) {
			isError = true;
			request.setAttribute("contraIndication", "<font color=red>* Contra-Indication is Required</font>");
		} else {
			request.setAttribute("txtContraIndication", contraIndication);
			productBean.setContraIndication(contraIndication);
		}

		if (ValidationUtils.isEmpty(purpose)) {
			isError = true;
			request.setAttribute("purpose", "<font color=red>* Purpose is Required</font>");
		} else {
			request.setAttribute("txtPurpose", purpose);
			productBean.setPurpose(purpose);
		}

		if (ValidationUtils.isEmpty(selRemedies) || selRemedies.equals("0")) {
			isError = true;
			request.setAttribute("remedies", "<font color=red>* Remedy is Required</font>");
		} else {
			request.setAttribute("selRemedies", selRemedies);
			productBean.setRemediesId(selRemedies);
		}

		if (ValidationUtils.isEmpty(selProductCategoryName) || selProductCategoryName.equals("0")) {
			isError = true;
			request.setAttribute("productCateogory", "<font color=red>* ProductCategory is Required</font>");
		} else {
			request.setAttribute("selProductCategoryName", selProductCategoryName);
			productBean.setProductCategoryId(selProductCategoryName);
		}

		if (ValidationUtils.isEmpty(description)) {
			isError = true;
			request.setAttribute("description", "<font color=red>* Description is Required</font>");
		} else {
			request.setAttribute("txtDescription", description);
			productBean.setDescription(description);
		}
		if (ValidationUtils.isEmpty(productURL)) {
			isError = true;
			request.setAttribute("productURL", "<font color=red>* ProductURL is Required</font>");
		} else {
			request.setAttribute("txtProductURL", productURL);
			productBean.setProductURL(productURL);
		}


		if (isError) {
			productBean.setProductName(name);
			productBean.setContraIndication(contraIndication);
			productBean.setForwardLink(forwardLink);
			productBean.setImageLink(photoLink);
			productBean.setProductCategoryId(selProductCategoryName);
			productBean.setProductId(productId);
			productBean.setPurpose(purpose);
			productBean.setRemediesId(selRemedies);
			productBean.setInteraction(interaction);
			productBean.setDescription(description);
			productBean.setSideEffect(sideEffect);
			productBean.setProductURL(productURL);
			request.setAttribute("productBean", productBean);
			request.getRequestDispatcher("ProductEdit.jsp").forward(request, response);
		} else {
			productBean.setProductId(productId);
			if (new ProductDAO().update(productBean)) {
				request.getServletContext().removeAttribute("productMap");
				HashMap<String, ProductBean>  productMap = new ProductDAO().getProductMap();
				request.getServletContext().setAttribute("productMap", productMap);
				response.sendRedirect("ProductListServlet");
				request.getServletContext().removeAttribute("remediesMap");
				HashMap<String, RemediesBean> remediesMap = new RemediesDAO().getRemediesListHashmap();
				request.getServletContext().setAttribute("remediesMap", remediesMap);
				request.getServletContext().removeAttribute("productCategoryMap");
				HashMap<String, ArrayList<ProductBean>> productCategoryMap = new ProductCategoryDAO().getCategoryMap();
				request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
			} else {
				request.getRequestDispatcher("ProductEdit.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
