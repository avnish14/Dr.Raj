package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.ProductIndicationBean;
import DrRAJ.Utils.DBConnection;
import DrRAJ.Utils.GenrateMathodsUtils;

public class ProductIndicationDAO {

	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	boolean result = false;

	public boolean insert(ProductIndicationBean bean) {

		String temp[] = bean.getIndication().split("=");
		for (int i = 0; i < temp.length; i++) {
			conn = DBConnection.getConnection();
			if (conn != null) {
				String insertSQL = "INSERT INTO productindication(productIndicationId,productId,indication) values(?,?,?)";
				try {

					pstmt = conn.prepareStatement(insertSQL);
					pstmt.setString(1, GenrateMathodsUtils.getRandomString(15));
					pstmt.setString(2, bean.getProductId());
					pstmt.setString(3, temp[i]);

					int rowsAffected = pstmt.executeUpdate();

					if (rowsAffected > 0) {
						result = true;
					} else {
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {

				}

			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<ProductIndicationBean> getList() {
		ArrayList<ProductIndicationBean> list = new ArrayList<ProductIndicationBean>();
		String sql = "select * from productindication,product where productindication.productId=product.productId";
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				ProductIndicationBean bean = null;
				while (rs.next()) {
					bean = new ProductIndicationBean();
					bean.setProductId(rs.getString("productId"));
					bean.setProductIndicationId(rs.getString("productIndicationId"));
					bean.setProductName(rs.getString("productName"));
					bean.setIndication(rs.getString("indication"));
					list.add(bean);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}

	public boolean delete(String productIndicationId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM productindication WHERE productIndicationId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, productIndicationId);

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}

	public ProductIndicationBean getByPK(String productIndicationId) {

		conn = DBConnection.getConnection();
		ProductIndicationBean bean = null;
		if (conn != null) {
			String selectSQL = "select * from productindication where productIndicationId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, productIndicationId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new ProductIndicationBean();
					bean.setProductId(rs.getString("productId"));
					bean.setProductIndicationId(rs.getString("productIndicationId"));
					bean.setIndication(rs.getString("indication"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	public boolean update(ProductIndicationBean bean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE productindication set productId=?,indication=? WHERE productIndicationId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, bean.getProductId());
				pstmt.setString(2, bean.getIndication());
				pstmt.setString(3, bean.getProductIndicationId());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
