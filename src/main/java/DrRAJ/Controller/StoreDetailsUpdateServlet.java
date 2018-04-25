package DrRAJ.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DrRAJ.Bean.StoreDetailsBean;
import DrRAJ.DAO.StoreDetailsDAO;
import DrRAJ.Utils.ValidationUtils;

public class StoreDetailsUpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("txtCityId");
		String storeId = request.getParameter("storeId");
		String name = request.getParameter("txtStoreName");
		String address = request.getParameter("txtAddress");
		String cn1 = request.getParameter("txtCN1");
		String cn2 = request.getParameter("txtCN2");

		StoreDetailsBean bean = new StoreDetailsBean();
		bean.setStoreId(storeId);
		bean.setContact2(cn2);
		boolean isError = false;
		if (ValidationUtils.isEmpty(name)) {
			isError = true;
			bean.setName("");
			request.setAttribute("name", " <font color='red'> * Name is Required </font>");
		} else {
			request.setAttribute("txtStoreName", name);
			bean.setName(name);
		}

		if (ValidationUtils.isEmpty(type) || type.equals("0")) {
			isError = true;
			bean.setCityId("");
			request.setAttribute("city", " <font color='red'> * City is Required </font>");
		} else {
			request.setAttribute("txtCityId", type);
			bean.setCityId(type);
		}

		if (ValidationUtils.isEmpty(address)) {
			isError = true;
			request.setAttribute("address", " <font color='red'> * Address is Required </font>");
			bean.setAddress("");
		} else {
			request.setAttribute("txtAddress", address);
			bean.setAddress(address);

		}
		if (ValidationUtils.isEmpty(cn1)) {
			isError = true;
			request.setAttribute("CN1", " <font color='red'> * Contact No. is Required </font>");
			bean.setContact1("");
		} else {
			request.setAttribute("txtCN1", cn1);
			bean.setContact1(cn1);
		}

		if (isError) {
			request.setAttribute("txtCN2", cn2);
			request.setAttribute("storeBean", bean);
			request.getRequestDispatcher("StoreDetailsEdit.jsp").forward(request, response);
		} else {
			bean.setContact2(cn2);
			if (new StoreDetailsDAO().update(bean)) {
				response.sendRedirect("StoreDetailsListServlet");
			} else {
				request.getRequestDispatcher("StoreDetailsInsert.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
