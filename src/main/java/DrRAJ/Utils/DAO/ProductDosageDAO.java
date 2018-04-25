package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.ProductDosageBean;
import DrRAJ.Utils.DBConnection;
import DrRAJ.Utils.GenrateMathodsUtils;

public class ProductDosageDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(ProductDosageBean productDosageBean) {
		String temp[] = productDosageBean.getContent().split("=");
		for (int i = 0; i < temp.length; i++) {
			connection = DBConnection.getConnection();
			if (connection != null) {
				String insertSQL = "INSERT INTO productdosage(productDosageId, productId, content)  "
						+ "values (?,?,?)";
				try {
					connection.setAutoCommit(false);
					pstmt = connection.prepareStatement(insertSQL);
					pstmt.setString(1, GenrateMathodsUtils.getRandomString(15));
					pstmt.setString(2, productDosageBean.getProductId());
					pstmt.setString(3, temp[i]);
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
		}
		return result;
	}

	public List<ProductDosageBean> getList() {

		List<ProductDosageBean> listOfProductDosage = new ArrayList<ProductDosageBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from productdosage pd,product p WHERE p.productId=pd.productId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

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

	public ProductDosageBean getByPK(String productDosageId) {

		connection = DBConnection.getConnection();
		ProductDosageBean productDosage = new ProductDosageBean();

		if (connection != null) {
			String selectSQL = "Select * from productdosage pd,product p WHERE p.productId=pd.productId and productDosageId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, productDosageId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					productDosage.setProductDosageId(rs.getString("productDosageId"));
					productDosage.setContent(rs.getString("content"));
					productDosage.setProductId(rs.getString("productId"));
					productDosage.setProductName(rs.getString("productName"));
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
		return productDosage;
	}

	public boolean update(ProductDosageBean productDosageBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE productdosage SET productId=?,content=? where productDosageId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(3, productDosageBean.getProductDosageId());
				pstmt.setString(1, productDosageBean.getProductId());
				pstmt.setString(2, productDosageBean.getContent());
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

	public boolean delete(String productDosageId) {

		connection = (Connection) DBConnection.getConnection();
		if (connection != null) {
			String sql = "delete from productdosage where productDosageId=?";
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, productDosageId);
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

}
