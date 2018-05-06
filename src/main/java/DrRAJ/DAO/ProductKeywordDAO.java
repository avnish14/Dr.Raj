package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.ProductKeywordBean;
import DrRAJ.Utils.DBConnection;
import DrRAJ.Utils.GenrateMathodsUtils;

public class ProductKeywordDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(ProductKeywordBean bean) {
		String temp[] = bean.getKeyword().split("=");
		for (int i = 0; i < temp.length; i++) {

			connection = DBConnection.getConnection();
			if (connection != null) {
				String insertSQL = "INSERT INTO productkeyword(keyword,productId,productkeywordId)" + " values(?,?,?)";
				try {
					connection.setAutoCommit(false);
					pstmt = connection.prepareStatement(insertSQL);
					pstmt.setString(1, temp[i]);
					pstmt.setString(2, bean.getProductId());
					pstmt.setString(3, GenrateMathodsUtils.getRandomString(15));
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

	public List<ProductKeywordBean> getList() {

		List<ProductKeywordBean> listOfProductKeyword = new ArrayList<ProductKeywordBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from productkeyword bk,product b where b.productId=bk.productId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ProductKeywordBean productKeyword = null;
				while (rs.next()) {
					productKeyword = new ProductKeywordBean();

					productKeyword.setProductId(rs.getString("productId"));
					productKeyword.setProductName(rs.getString("productName"));
					productKeyword.setKeyword(rs.getString("keyword"));
					productKeyword.setProductKeywordId(rs.getString("productKeywordId"));

					listOfProductKeyword.add(productKeyword);
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

		return listOfProductKeyword;

	}

	public boolean delete(String productId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM productkeyword WHERE productKeywordId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, productId);

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

	public ProductKeywordBean getByPK(String productKeywordId) {

		connection = DBConnection.getConnection();
		ProductKeywordBean productKeywordBean = new ProductKeywordBean();

		if (connection != null) {
			String selectSQL = "Select * from productKeyword WHERE productKeywordId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, productKeywordId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					productKeywordBean.setProductId(rs.getString("productId"));
					productKeywordBean.setKeyword(rs.getString("keyword"));
					productKeywordBean.setProductKeywordId(rs.getString("productkeywordId"));
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
		return productKeywordBean;
	}

	public boolean update(ProductKeywordBean productKeywordBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE productkeyword set keyword=?,productId=? WHERE productKeywordId=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, productKeywordBean.getKeyword());
				pstmt.setString(2, productKeywordBean.getProductId());
				pstmt.setString(3, productKeywordBean.getProductKeywordId());

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
}
