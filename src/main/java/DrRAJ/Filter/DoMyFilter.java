
package DrRAJ.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import DrRAJ.Bean.BookBean;
import DrRAJ.Bean.IngredientBean;
import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.Bean.PriceBean;
import DrRAJ.Bean.ProductBean;
import DrRAJ.Bean.ProductCompositionBean;
import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.Bean.RemediesBean;
import DrRAJ.DAO.BookDAO;
import DrRAJ.DAO.JointVenturesDAO;
import DrRAJ.DAO.ProductCategoryDAO;
import DrRAJ.DAO.ProductDAO;
import DrRAJ.DAO.RemediesDAO;

public class DoMyFilter implements Filter {

	HashMap<String, RemediesBean> remediesMap;
	HashMap<String, ArrayList<ProductBean>> productCategoryMap;
	HashMap<String, ProductBean> productMap;
	HashMap<String, BookBean> bookMap;
	HashMap<String, ArrayList<ProductIndicationBean>> productIndicationMap;
	HashMap<String, ArrayList<ProductCompositionBean>> productCompositionMap;
	HashMap<String, ArrayList<PriceBean>> priceMap;
	HashMap<String, ArrayList<ProductDosageBean>> productDosageMap;
	HashMap<String, ArrayList<IngredientBean>> ingredientMap;
	HashMap<String, JointVenturesBean> jointVenturesMap;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		int a = ((HttpServletRequest) request).getRequestURI().toString().split("/").length;
		String s[] = ((HttpServletRequest) request).getRequestURI().toString().split("/");

		if (a == 2) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			if (s[2].equalsIgnoreCase("login") || s[2].equalsIgnoreCase("company-info")
					|| s[2].equalsIgnoreCase("manufacturing-practices")
					|| s[2].equalsIgnoreCase("contract-manufacturing") || s[2].equalsIgnoreCase("dr-raj-products")
					|| s[2].equalsIgnoreCase("find-a-store-or-practitioner") || s[2].equalsIgnoreCase("faq")
					|| s[2].equalsIgnoreCase("know-your-medicine") || s[2].equalsIgnoreCase("remedies")
					|| s[2].equalsIgnoreCase("mind-body-spirit") || s[2].equalsIgnoreCase("homoeopathic-self-help")
					|| s[2].equalsIgnoreCase("company-management") || s[2].equalsIgnoreCase("meet-the-founder")
					|| s[2].equalsIgnoreCase("our-core-value-and-mission") || s[2].equalsIgnoreCase("manager")
					|| s[2].equalsIgnoreCase("homoeopathic-consultancy") || s[2].equalsIgnoreCase("contact-us")
					|| s[2].equalsIgnoreCase("satisfied-customer") || s[2].equalsIgnoreCase("news")
					|| s[2].equalsIgnoreCase("joint-ventures")|| s[2].equalsIgnoreCase("not-found")

			) {
				chain.doFilter(request, response);
			} else {

				IntitilzationMap(request, response);

				if (a == 3 && !(s[2].contains(".jsp") || s[2].contains("Servlet") || s[2].contains(".html")
						|| s[2].contains(".htm") || s[2].contains("servlet"))) {

					if (remediesMap == null || productCategoryMap == null || productMap == null || bookMap == null
							|| productIndicationMap == null || productCompositionMap == null || priceMap == null
							|| productDosageMap == null || ingredientMap == null || jointVenturesMap == null) {
						remediesMap = new RemediesDAO().getRemediesListHashmap();
						productCategoryMap = new ProductCategoryDAO().getCategoryMap();
						productMap = new ProductDAO().getProductMap();
						bookMap = new BookDAO().getBookMap();
						productIndicationMap = new ProductDAO().getIndication();
						productCompositionMap = new ProductDAO().getComposition();
						priceMap = new ProductDAO().getPrice();
						productDosageMap = new ProductDAO().getDosage();
						ingredientMap = new ProductDAO().getIngredient();
						jointVenturesMap = new JointVenturesDAO().getListMap();
						request.getServletContext().setAttribute("remediesMap", remediesMap);
						request.getServletContext().setAttribute("productCategoryMap", productCategoryMap);
						request.getServletContext().setAttribute("productMap", productMap);
						request.getServletContext().setAttribute("bookMap", bookMap);
						request.getServletContext().setAttribute("productIndicationMap", productIndicationMap);
						request.getServletContext().setAttribute("productCompositionMap", productCompositionMap);
						request.getServletContext().setAttribute("priceMap", priceMap);
						request.getServletContext().setAttribute("productDosageMap", productDosageMap);
						request.getServletContext().setAttribute("ingredientMap", ingredientMap);
						request.getServletContext().setAttribute("jointVenturesMap", jointVenturesMap);
					}
					if (remediesMap.containsKey(s[2])) {
						RemediesBean remediesbean = remediesMap.get(s[2]);
						if (remediesbean != null) {
							request.setAttribute("remediesbean", remediesbean);
							String str = "/RemediesDetails.jsp";
							request.getRequestDispatcher(str).forward(request, response);
						}
					} else if (productCategoryMap.containsKey(s[2])) {
						ArrayList<ProductBean> categoryBean = productCategoryMap.get(s[2]);
						request.setAttribute("categoryBean", categoryBean);
						String str = "/ProductCategory.jsp";
						request.getRequestDispatcher(str).forward(request, response);
					} else if (productMap.containsKey(s[2])) {
						ProductBean bean = productMap.get(s[2]);
						if (bean != null) {
							request.setAttribute("bean", bean);
							String str = "/Product.jsp";
							request.getRequestDispatcher(str).forward(request, response);
						}
					} else if (s[2].equalsIgnoreCase("buddhism-meditation")
							|| s[2].equalsIgnoreCase("chakras-kundalini") || s[2].equalsIgnoreCase("yoga")
							|| s[2].equalsIgnoreCase("spiritual-philosophy") || s[2].equalsIgnoreCase("eating-disorder")
							|| s[2].equalsIgnoreCase("psychology-relationship")
							|| s[2].equalsIgnoreCase("first-aid-acutes") || s[2].equalsIgnoreCase("children")
							|| s[2].equalsIgnoreCase("therapeutics") || s[2].equalsIgnoreCase("for-beginners")
							|| s[2].equalsIgnoreCase("general") || s[2].equalsIgnoreCase("homoeopathic-research")) {
						request.setAttribute("type", s[2]);
						request.getRequestDispatcher("BookByType.jsp").forward(request, response);
					} else if (bookMap.containsKey(s[2])) {
						BookBean bookBean = bookMap.get(s[2]);
						if (bookBean != null) {
							request.setAttribute("bean", bookBean);
							String str = "/BookDetails.jsp";
							request.getRequestDispatcher(str).forward(request, response);
						}
					}

					else if (jointVenturesMap.containsKey(s[2])) {
						JointVenturesBean jointVenturesBean = jointVenturesMap.get(s[2]);
						if (jointVenturesBean != null) {
							request.setAttribute("jointVenturesBean", jointVenturesBean);
							String str = "/JointVenturesDetails.jsp";
							request.getRequestDispatcher(str).forward(request, response);
						} else {
							request.getRequestDispatcher("404.jsp").forward(request, response);
						}
					} else {
						chain.doFilter(request, response);
					}
				} else {
					chain.doFilter(request, response);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void IntitilzationMap(ServletRequest request, ServletResponse response) {
		remediesMap = (HashMap<String, RemediesBean>) request.getServletContext().getAttribute("remediesMap");
		productCategoryMap = (HashMap<String, ArrayList<ProductBean>>) request.getServletContext()
				.getAttribute("productCategoryMap");
		productMap = (HashMap<String, ProductBean>) request.getServletContext().getAttribute("productMap");
		bookMap = (HashMap<String, BookBean>) request.getServletContext().getAttribute("bookMap");
		productIndicationMap = (HashMap<String, ArrayList<ProductIndicationBean>>) request.getServletContext()
				.getAttribute("productIndicationMap");
		productCompositionMap = (HashMap<String, ArrayList<ProductCompositionBean>>) request.getServletContext()
				.getAttribute("productCompositionMap");
		priceMap = (HashMap<String, ArrayList<PriceBean>>) request.getServletContext().getAttribute("priceMap");
		productDosageMap = (HashMap<String, ArrayList<ProductDosageBean>>) request.getServletContext()
				.getAttribute("productDosageMap");
		ingredientMap = (HashMap<String, ArrayList<IngredientBean>>) request.getServletContext()
				.getAttribute("ingredientMap");
		jointVenturesMap = (HashMap<String, JointVenturesBean>) request.getServletContext()
				.getAttribute("jointVenturesMap");
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
/*
 * package DrRAJ.Filter;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.HashMap;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.http.HttpServletRequest;
 * 
 * import DrRAJ.Bean.BookBean; import DrRAJ.Bean.IngredientBean; import
 * DrRAJ.Bean.PriceBean; import DrRAJ.Bean.ProductBean; import
 * DrRAJ.Bean.ProductCompositionBean; import DrRAJ.Bean.ProductDosageBean;
 * import DrRAJ.Bean.ProductIndicationBean; import DrRAJ.Bean.RemediesBean;
 * import DrRAJ.DAO.BookDAO; import DrRAJ.DAO.ProductCategoryDAO; import
 * DrRAJ.DAO.ProductDAO; import DrRAJ.DAO.RemediesDAO;
 * 
 * public class DoMyFilter implements Filter {
 * 
 * HashMap<String, RemediesBean> remediesMap; HashMap<String,
 * ArrayList<ProductBean>> productCategoryMap; HashMap<String, ProductBean>
 * productMap; HashMap<String, BookBean> bookMap; HashMap<String,
 * ArrayList<ProductIndicationBean>> productIndicationMap; HashMap<String,
 * ArrayList<ProductCompositionBean>> productCompositionMap; HashMap<String,
 * ArrayList<PriceBean>> priceMap; HashMap<String, ArrayList<ProductDosageBean>>
 * productDosageMap; HashMap<String, ArrayList<IngredientBean>> ingredientMap;
 * 
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException {
 * 
 * int a = ((HttpServletRequest)
 * request).getRequestURI().toString().split("/").length; String s[] =
 * ((HttpServletRequest) request).getRequestURI().toString().split("/");
 * 
 * if (a == 0) { request.getRequestDispatcher("index.jsp").forward(request,
 * response); } else { if (s[1].equalsIgnoreCase("login") ||
 * s[1].equalsIgnoreCase("company-info") ||
 * s[1].equalsIgnoreCase("manufacturing-practices") ||
 * s[1].equalsIgnoreCase("contract-manufacturing") ||
 * s[1].equalsIgnoreCase("dr-raj-products") ||
 * s[1].equalsIgnoreCase("find-a-store-or-practitioner") ||
 * s[1].equalsIgnoreCase("faq") || s[1].equalsIgnoreCase("know-your-medicine")
 * || s[1].equalsIgnoreCase("remedies") ||
 * s[1].equalsIgnoreCase("mind-body-spirit") ||
 * s[1].equalsIgnoreCase("homoeopathic-self-help") ||
 * s[1].equalsIgnoreCase("company-management") ||
 * s[1].equalsIgnoreCase("meet-the-founder") ||
 * s[1].equalsIgnoreCase("our-core-value-and-mission") ||
 * s[1].equalsIgnoreCase("manager") ||
 * s[1].equalsIgnoreCase("homoeopathic-consultancy") ||
 * s[1].equalsIgnoreCase("contact-us") ||
 * s[1].equalsIgnoreCase("satisfied-customer")|| s[1].equalsIgnoreCase("news")
 * 
 * ) { chain.doFilter(request, response); } else {
 * 
 * IntitilzationMap(request, response);
 * 
 * if (a == 2 && !(s[1].contains(".jsp") || s[1].contains("Servlet") ||
 * s[1].contains(".html") || s[1].contains(".htm") || s[1].contains("servlet")))
 * {
 * 
 * if (remediesMap == null || productCategoryMap == null || productMap == null
 * || bookMap == null) { remediesMap = new
 * RemediesDAO().getRemediesListHashmap(); productCategoryMap = new
 * ProductCategoryDAO().getCategoryMap(); productMap = new
 * ProductDAO().getProductMap(); bookMap = new BookDAO().getBookMap();
 * productIndicationMap = new ProductDAO().getIndication();
 * productCompositionMap = new ProductDAO().getComposition(); priceMap = new
 * ProductDAO().getPrice(); productDosageMap= new ProductDAO().getDosage();
 * ingredientMap = new ProductDAO().getIngredient();
 * request.getServletContext().setAttribute("remediesMap", remediesMap);
 * request.getServletContext().setAttribute("productCategoryMap",
 * productCategoryMap); request.getServletContext().setAttribute("productMap",
 * productMap); request.getServletContext().setAttribute("bookMap", bookMap);
 * request.getServletContext().setAttribute("productIndicationMap",
 * productIndicationMap);
 * request.getServletContext().setAttribute("productCompositionMap",
 * productCompositionMap); request.getServletContext().setAttribute("priceMap",
 * priceMap); request.getServletContext().setAttribute("productDosageMap",
 * productDosageMap); request.getServletContext().setAttribute("ingredientMap",
 * ingredientMap); System.out.println("Hiii"); } if
 * (remediesMap.containsKey(s[1])) { RemediesBean remediesbean =
 * remediesMap.get(s[1]); if (remediesbean != null) {
 * request.setAttribute("remediesbean", remediesbean);
 * System.out.println("Remedies"); String str = "/RemediesDetails.jsp";
 * request.getRequestDispatcher(str).forward(request, response); } } else if
 * (productCategoryMap.containsKey(s[1])) { ArrayList<ProductBean> categoryBean
 * = productCategoryMap.get(s[1]); if (categoryBean != null &&
 * categoryBean.size() != 0) { System.out.println("Product Category");
 * request.setAttribute("categoryBean", categoryBean); String str =
 * "/ProductCategory.jsp"; request.getRequestDispatcher(str).forward(request,
 * response); } } else if (productMap.containsKey(s[1])) { ProductBean bean =
 * productMap.get(s[1]); if (bean != null) { request.setAttribute("bean", bean);
 * String str = "/Product.jsp"; System.out.println("Product");
 * request.getRequestDispatcher(str).forward(request, response); } } else if
 * (s[1].equalsIgnoreCase("buddhism-meditation") ||
 * s[1].equalsIgnoreCase("chakras-kundalini") || s[1].equalsIgnoreCase("yoga")
 * || s[1].equalsIgnoreCase("spiritual-philosophy") ||
 * s[1].equalsIgnoreCase("eating-disorder") ||
 * s[1].equalsIgnoreCase("psychology-relationship") ||
 * s[1].equalsIgnoreCase("first-aid-acutes") ||
 * s[1].equalsIgnoreCase("children") || s[1].equalsIgnoreCase("therapeutics") ||
 * s[1].equalsIgnoreCase("for-beginners") || s[1].equalsIgnoreCase("general") ||
 * s[1].equalsIgnoreCase("homoeopathic-research")) {
 * request.setAttribute("type", s[1]);
 * request.getRequestDispatcher("BookByType.jsp").forward(request, response); }
 * else if (bookMap.containsKey(s[1])) { BookBean bookBean = bookMap.get(s[1]);
 * if (bookBean != null) { request.setAttribute("bean", bookBean); String str =
 * "/BookDetails.jsp"; System.out.println("Book");
 * request.getRequestDispatcher(str).forward(request, response); } else {
 * request.getRequestDispatcher("404.jsp").forward(request, response); } } else
 * { chain.doFilter(request, response); } } else { chain.doFilter(request,
 * response); } } } }
 * 
 * @SuppressWarnings("unchecked") private void IntitilzationMap(ServletRequest
 * request, ServletResponse response) { remediesMap = (HashMap<String,
 * RemediesBean>) request.getServletContext().getAttribute("remediesMap");
 * productCategoryMap = (HashMap<String, ArrayList<ProductBean>>)
 * request.getServletContext() .getAttribute("productCategoryMap"); productMap =
 * (HashMap<String, ProductBean>)
 * request.getServletContext().getAttribute("productMap"); bookMap =
 * (HashMap<String, BookBean>)
 * request.getServletContext().getAttribute("bookMap"); productIndicationMap =
 * (HashMap<String, ArrayList<ProductIndicationBean>>)
 * request.getServletContext() .getAttribute("productIndicationMap");
 * productCompositionMap = (HashMap<String, ArrayList<ProductCompositionBean>>)
 * request.getServletContext() .getAttribute("productCompositionMap"); priceMap
 * = (HashMap<String, ArrayList<PriceBean>>)
 * request.getServletContext().getAttribute("priceMap"); productDosageMap =
 * (HashMap<String, ArrayList<ProductDosageBean>>)
 * request.getServletContext().getAttribute("productDosageMap"); ingredientMap =
 * (HashMap<String, ArrayList<IngredientBean>>)
 * request.getServletContext().getAttribute("ingredientMap"); }
 * 
 * public void destroy() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * public void init(FilterConfig arg0) throws ServletException { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * }
 * 
 */