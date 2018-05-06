package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DrRAJ.Bean.ProductBean;
import DrRAJ.Bean.RelatedProductBean;
import DrRAJ.Utils.DBConnection;
import DrRAJ.Utils.GenrateMathodsUtils;

public class ReletedProductDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(RelatedProductBean bean, String relatedProducts) {

		connection = DBConnection.getConnection();
		if (connection != null) {

			String arr[] = relatedProducts.split(" ");

			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i] + "Hiiii");
				String insertSQL = "INSERT INTO relatedproduct(relatedProductId,relatedId,productId)"
						+ " values(?,?,?)";
				try {
					pstmt = connection.prepareStatement(insertSQL);
					pstmt.setString(1, GenrateMathodsUtils.getRandomString(15));
					pstmt.setString(2, arr[i]);
					pstmt.setString(3, bean.getProductId());

					System.out.println("Inserted");
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected > 0) {
						result = true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {

				}

			}
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<RelatedProductBean> getList() {

		List<RelatedProductBean> listOfRelatedProduct = new ArrayList<RelatedProductBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			HashMap<String, ProductBean> hashMap = new ProductDAO().getListHashmap();
			String selectSQL = "Select * from relatedproduct";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				RelatedProductBean relatedProductBean = null;
				while (rs.next()) {
					relatedProductBean = new RelatedProductBean();

					relatedProductBean.setReletedProductId((rs.getString("relatedProductId")));
					relatedProductBean.setProductId(rs.getString("productId"));
					relatedProductBean.setProductName(hashMap.get(relatedProductBean.getProductId()).getProductName());
					relatedProductBean.setReletedId(rs.getString("relatedId"));
					relatedProductBean
							.setReletedProductName(hashMap.get(relatedProductBean.getReletedId()).getProductName());
					listOfRelatedProduct.add(relatedProductBean);
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
		return listOfRelatedProduct;

	}

	public boolean isExists(RelatedProductBean bean) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from relatedproduct where relatedId=? and productId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, bean.getReletedId());
				pstmt.setString(2, bean.getProductId());
				rs = pstmt.executeQuery();
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

	public boolean delete(String relatedProductId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM relatedproduct WHERE relatedProductId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, relatedProductId);

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

	public RelatedProductBean getByPK(String relatedProductId) {

		connection = DBConnection.getConnection();
		RelatedProductBean relatedProductBean = new RelatedProductBean();

		if (connection != null) {
			HashMap<String, ProductBean> hashMap = new ProductDAO().getListHashmap();
			String selectSQL = "Select * from relatedproduct WHERE relatedProductId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, relatedProductId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					relatedProductBean.setReletedProductId((rs.getString("relatedProductId")));
					relatedProductBean.setProductId(rs.getString("productId"));
					relatedProductBean.setProductName(hashMap.get(relatedProductBean.getProductId()).getProductName());
					relatedProductBean.setReletedId(rs.getString("relatedId"));
					relatedProductBean
							.setReletedProductName(hashMap.get(relatedProductBean.getReletedId()).getProductName());
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
		return relatedProductBean;
	}

	public boolean update(RelatedProductBean relatedProductBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE relatedproduct set relatedId=?,productId=? WHERE relatedProductId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(1, relatedProductBean.getReletedId());
				pstmt.setString(2, relatedProductBean.getProductId());
				pstmt.setString(3, relatedProductBean.getReletedProductId());
				System.out.println(relatedProductBean.getReletedId() + " " + relatedProductBean.getProductId() + " "
						+ relatedProductBean.getReletedProductId());
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

	public static void main(String[] args) {
		new ReletedProductDAO().getList();
	}
}
