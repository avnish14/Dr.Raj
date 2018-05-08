package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DrRAJ.Bean.IngredientBean;
import DrRAJ.Bean.PriceBean;
import DrRAJ.Bean.ProductBean;
import DrRAJ.Bean.ProductCompositionBean;
import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.Bean.ReviewBean;
import DrRAJ.Utils.DBConnection;

public class ProductDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public void cntIncrement(String productURL) {

		Connection connection = DBConnection.getConnection();
		try {
			if (connection != null) {
				String updateSQL = "update product set cnt=? where productURL=?";
				PreparedStatement statement = connection.prepareStatement(updateSQL);
				statement.setString(1, (new ProductDAO().getCnt(productURL) + 1) + "");
				statement.setString(2, productURL);
				int a = statement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insert(ProductBean productBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO product(productId, productName, imageLink, forwardLink, "
					+ "interaction, sideEffect, contraIndication, purpose, "
					+ "description, remediesId, productURL,productCategoryId) " + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, productBean.getProductId());
				pstmt.setString(2, productBean.getProductName());
				pstmt.setString(3, productBean.getImageLink());
				pstmt.setString(4, productBean.getForwardLink());
				pstmt.setString(5, productBean.getInteraction());
				pstmt.setString(6, productBean.getSideEffect());
				pstmt.setString(7, productBean.getContraIndication());
				pstmt.setString(8, productBean.getPurpose());
				pstmt.setString(9, productBean.getDescription());
				pstmt.setString(10, productBean.getRemediesId());
				pstmt.setString(11, productBean.getProductURL());
				pstmt.setString(12, productBean.getProductCategoryId());
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					result = true;
				}
			} catch (SQLException e) {
				try {
					connection.rollback();
					result = false;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					connection.commit();
					connection.setAutoCommit(true);
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}

	public boolean isProductExists(String name) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from product where productName=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
					return true;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public Integer getCnt(String productURL) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select cnt from product where productURL=?";
			try {
				connection = DBConnection.getConnection();
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, productURL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
					return rs.getInt("cnt");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<ProductBean> getList() {

		List<ProductBean> listOfProduct = new ArrayList<ProductBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from product p,remedies r,productcategory pc WHERE p.remediesId=r.remediesId and pc.productCategoryId=p.productCategoryId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ProductBean product = null;
				while (rs.next()) {
					product = new ProductBean();

					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setRemediesName(rs.getString("name"));
					product.setProductCategoryName(rs.getString("productCategoryName"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setRemediesImageLink(rs.getString("photoLink"));
					product.setMinPrice(rs.getString("minPrice"));
					listOfProduct.add(product);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfProduct;

	}

	public List<ProductBean> getAllList(String productId) {

		List<ProductBean> listOfProduct = new ArrayList<ProductBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from product p,remedies r,productcategory pc WHERE p.remediesId=r.remediesId and pc.productCategoryId=p.productCategoryId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ProductBean product = null;
				while (rs.next()) {
					product = new ProductBean();

					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setRemediesName(rs.getString("name"));
					product.setProductCategoryName(rs.getString("productCategoryName"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setRemediesImageLink(rs.getString("photoLink"));
					product.setMinPrice(rs.getString("minPrice"));
					listOfProduct.add(product);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfProduct;

	}

	public HashMap<String, ProductBean> getProductMap() {

		connection = DBConnection.getConnection();
		HashMap<String, ProductBean> map = new HashMap<String, ProductBean>();
		if (connection != null) {
			String selectSQL = "Select * from product p,remedies r,productcategory pc WHERE p.remediesId=r.remediesId and pc.productCategoryId=p.productCategoryId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ProductBean product = null;
				while (rs.next()) {
					product = new ProductBean();
					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setRemediesName(rs.getString("name"));
					product.setProductCategoryName(rs.getString("productCategoryName"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setRemediesImageLink(rs.getString("photoLink"));
					product.setMinPrice(rs.getString("minPrice"));
					product.setRate(new ProductDAO().getAvgReview(product.getProductId()));
					System.out.println(product.getRate() + " Rate");
					map.put(product.getProductURL(), product);
				}
				System.out.println(map.size());
				return map;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return map;

	}

	public List<ProductBean> getAllListByRemedies(String remediesId) {

		List<ProductBean> listOfProduct = new ArrayList<ProductBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from product where remediesId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, remediesId);
				rs = pstmt.executeQuery();

				ProductBean product = null;
				while (rs.next()) {
					product = new ProductBean();
					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setMinPrice(rs.getString("minPrice"));
					product.setRate(new ProductDAO().getAvgReview(rs.getString("productId")));
					listOfProduct.add(product);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfProduct;

	}

	public ProductBean getByPK(String productId) {

		connection = DBConnection.getConnection();
		ProductBean product = new ProductBean();

		if (connection != null) {
			String selectSQL = "Select * from product p,remedies r,productcategory pc WHERE p.remediesId=r.remediesId and pc.productCategoryId=p.productCategoryId and productId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, productId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setRemediesName(rs.getString("name"));
					product.setProductCategoryName(rs.getString("productCategoryName"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setRemediesImageLink(rs.getString("photoLink"));
					product.setMinPrice(rs.getString("minPrice"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return product;
	}

	public ProductBean getByURL(String productURL) {

		connection = DBConnection.getConnection();
		ProductBean product = null;

		if (connection != null) {
			String selectSQL = "Select * from product p,remedies r,productcategory pc WHERE p.remediesId=r.remediesId and pc.productCategoryId=p.productCategoryId and productURL=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, productURL);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					product = new ProductBean();
					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setRemediesName(rs.getString("name"));
					product.setProductCategoryName(rs.getString("productCategoryName"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setRemediesImageLink(rs.getString("photoLink"));
					product.setMinPrice(rs.getString("minPrice"));
					product.setRate(new ProductDAO().getAvgReview(product.getProductId()));
				}
				return product;

			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public boolean update(ProductBean productBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE product set productName=?, imageLink=?, forwardLink=?, "
					+ "interaction=?, sideEffect=?, contraIndication=?, purpose=?, "
					+ "description=?, remediesId=?, productCategoryId=?, productURL=? where productId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(12, productBean.getProductId());
				pstmt.setString(1, productBean.getProductName());
				pstmt.setString(2, productBean.getImageLink());
				pstmt.setString(3, productBean.getForwardLink());
				pstmt.setString(4, productBean.getInteraction());
				pstmt.setString(5, productBean.getSideEffect());
				pstmt.setString(6, productBean.getContraIndication());
				pstmt.setString(7, productBean.getPurpose());
				pstmt.setString(8, productBean.getDescription());
				pstmt.setString(9, productBean.getRemediesId());
				pstmt.setString(10, productBean.getProductCategoryId());
				pstmt.setString(11, productBean.getProductURL());
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}

	public boolean updateMinPrice(String price, String productId) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE product set minPrice=? where productId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(1, price);
				pstmt.setString(2, productId);
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}

	public boolean delete(String productId) {

		connection = (Connection) DBConnection.getConnection();
		if (connection != null) {
			String sql = "delete from product where productId=?";
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, productId);
				int row = statement.executeUpdate();

				if (row != 0) {
					return true;
				}

			} catch (Exception e) {

			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	// Product Id, Product Object
	public HashMap<String, ProductBean> getListHashmap() {
		HashMap<String, ProductBean> listOfProduct = new HashMap<String, ProductBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from product p,remedies r,productcategory pc WHERE p.remediesId=r.remediesId and pc.productCategoryId=p.productCategoryId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ProductBean product = null;
				while (rs.next()) {
					product = new ProductBean();
					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setRemediesName(rs.getString("name"));
					product.setProductCategoryName(rs.getString("productCategoryName"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setRemediesImageLink(rs.getString("photoLink"));
					product.setMinPrice(rs.getString("minPrice"));
					product.setRate(new ProductDAO().getAvgReview(product.getProductId()));
					listOfProduct.put(product.getProductId(), product);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfProduct;

	}

	public ArrayList<ProductIndicationBean> getIndication(String productId) {

		ArrayList<ProductIndicationBean> list = new ArrayList<ProductIndicationBean>();
		connection = DBConnection.getConnection();
		ProductIndicationBean bean = null;
		if (connection != null) {
			String selectSQL = "select * from productindication pi,product p where pi.productId=p.productId and p.productId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, productId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new ProductIndicationBean();
					bean.setProductId(rs.getString("productId"));
					bean.setProductIndicationId(rs.getString("productIndicationId"));
					bean.setIndication(rs.getString("indication"));
					list.add(bean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public ArrayList<ProductCompositionBean> getComposition(String productId) {

		ArrayList<ProductCompositionBean> listOfProductComposition = new ArrayList<ProductCompositionBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from productcomposition pc,product p,ingredients i where pc.productId=p.productId and pc.ingredientsId=i.ingredientsId and p.productId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, productId);
				rs = pstmt.executeQuery();

				ProductCompositionBean productComposition = null;
				while (rs.next()) {
					productComposition = new ProductCompositionBean();

					productComposition.setCompositionContent(rs.getString("compositionContent"));
					productComposition.setIngredientsId(rs.getString("ingredientsId"));
					productComposition.setIngredientsName(rs.getString("title"));
					productComposition.setProductCompositionId(rs.getString("productCompositionId"));
					productComposition.setProductId(rs.getString("productId"));
					productComposition.setProductName(rs.getString("productName"));
					listOfProductComposition.add(productComposition);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfProductComposition;

	}

	public ArrayList<PriceBean> getPrice(String productId) {
		ArrayList<PriceBean> list = new ArrayList<PriceBean>();
		String sql = "select * from price,product where price.productId=product.productId and product.productId=? order by packageSize";
		connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, productId);
				rs = pstmt.executeQuery();
				PriceBean bean = null;
				while (rs.next()) {
					bean = new PriceBean();
					bean.setProductId(rs.getString("productId"));
					bean.setPriceId(rs.getString("priceId"));
					bean.setProductName(rs.getString("productName"));
					bean.setPackageSize(rs.getString("packageSize"));
					bean.setPrice(rs.getString("price"));
					list.add(bean);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}

	public ArrayList<ProductDosageBean> getDosage(String productId) {

		ArrayList<ProductDosageBean> listOfProductDosage = new ArrayList<ProductDosageBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from productdosage pd,product p WHERE p.productId=pd.productId and p.productId=? order by content asc";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, productId);
				rs = pstmt.executeQuery();

				ProductDosageBean productDosage = null;
				while (rs.next()) {
					productDosage = new ProductDosageBean();
					productDosage.setProductDosageId(rs.getString("productDosageId"));
					productDosage.setContent(rs.getString("content"));
					productDosage.setProductId(rs.getString("productId"));
					productDosage.setProductName(rs.getString("productName"));
					listOfProductDosage.add(productDosage);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfProductDosage;

	}

	public ArrayList<IngredientBean> getIngredient(String productId) {
		ArrayList<IngredientBean> list = new ArrayList<IngredientBean>();
		connection = (Connection) DBConnection.getConnection();
		if (connection != null) {
			String sql = "SELECT * FROM productcomposition pc, product p, ingredients i where p.productId=pc.productId and i.ingredientsId=pc.ingredientsId and p.productId=?";
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, productId);
				ResultSet rs = statement.executeQuery();
				IngredientBean bean = new IngredientBean();
				while (rs.next()) {
					bean = new IngredientBean();
					bean.setDescription(rs.getString("i.description"));
					bean.setIngredientsId(rs.getString("ingredientsId"));
					bean.setPhotoLink(rs.getString("photoLink"));
					bean.setTitle(rs.getString("title"));
					list.add(bean);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public List<ReviewBean> getReview(String productId) {

		List<ReviewBean> listOfReview = new ArrayList<ReviewBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from review,product where product.productId=review.productId and product.productId=? and isValid='1'";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, productId);
				rs = pstmt.executeQuery();

				ReviewBean review = null;
				while (rs.next()) {
					review = new ReviewBean();
					review.setReviewId(rs.getString("reviewId"));
					review.setDescription(rs.getString("description"));
					review.setCustomerName(rs.getString("customerName"));
					review.setIsValid(rs.getString("isValid"));
					review.setProductId(rs.getString("productId"));
					review.setProductName(rs.getString("productName"));
					review.setRating(rs.getInt("rating"));
					review.setTitle(rs.getString("title"));
					listOfReview.add(review);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return listOfReview;

	}

	public List<ProductBean> getAllRelatedProducts(String remediesId) {

		List<ProductBean> listOfProduct = new ArrayList<ProductBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "SELECT * from product WHERE remediesId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, remediesId);
				rs = pstmt.executeQuery();
				ProductBean product = null;
				while (rs.next()) {
					product = new ProductBean();
					product.setProductId(rs.getString("productId"));
					product.setDescription(rs.getString("description"));
					product.setImageLink(rs.getString("imageLink"));
					product.setContraIndication(rs.getString("contraIndication"));
					product.setForwardLink(rs.getString("forwardLink"));
					product.setProductCategoryId(rs.getString("productCategoryId"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurpose(rs.getString("purpose"));
					product.setRemediesId(rs.getString("remediesId"));
					product.setSideEffect(rs.getString("sideEffect"));
					product.setInteraction(rs.getString("interaction"));
					product.setProductURL(rs.getString("productURL"));
					product.setCnt(rs.getInt("cnt") + "");
					product.setMinPrice(rs.getString("minPrice"));
					product.setRate(new ProductDAO().getAvgReview(product.getProductId()));
					listOfProduct.add(product);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return listOfProduct;
	}

	public HashMap<String, ArrayList<ProductIndicationBean>> getIndication() {
		HashMap<String, ArrayList<ProductIndicationBean>> map = new HashMap<String, ArrayList<ProductIndicationBean>>();
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "select * from productindication";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					map.put(rs.getString("productId"), null);
				}

				for (String str : map.keySet()) {
					map.put(str, getIndication(str));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public HashMap<String, ArrayList<ProductCompositionBean>> getComposition() {
		HashMap<String, ArrayList<ProductCompositionBean>> map = new HashMap<String, ArrayList<ProductCompositionBean>>();
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "select * from productcomposition";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					map.put(rs.getString("productId"), null);
				}

				for (String str : map.keySet()) {
					map.put(str, getComposition(str));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public HashMap<String, ArrayList<PriceBean>> getPrice() {
		HashMap<String, ArrayList<PriceBean>> map = new HashMap<String, ArrayList<PriceBean>>();
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "select * from price";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					map.put(rs.getString("productId"), null);
				}

				for (String str : map.keySet()) {
					map.put(str, getPrice(str));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public HashMap<String, ArrayList<ProductDosageBean>> getDosage() {
		HashMap<String, ArrayList<ProductDosageBean>> map = new HashMap<String, ArrayList<ProductDosageBean>>();
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "select DISTINCT(productId) from productdosage";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					map.put(rs.getString("productId"), null);
				}

				for (String str : map.keySet()) {
					map.put(str, getDosage(str));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public HashMap<String, ArrayList<IngredientBean>> getIngredient() {
		HashMap<String, ArrayList<IngredientBean>> map = new HashMap<String, ArrayList<IngredientBean>>();
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "select * from productcomposition";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					map.put(rs.getString("productId"), null);
				}

				for (String str : map.keySet()) {
					map.put(str, getIngredient(str));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public String getAvgReview(String productId) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "Select avg(rating) as avg from review where productId=? and isValid='1'";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, productId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					return rs.getString("avg");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}
}
