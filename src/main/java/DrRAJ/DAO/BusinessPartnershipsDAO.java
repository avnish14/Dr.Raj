package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.BusinessPartnershipsBean;
import DrRAJ.Utils.DBConnection;

public class BusinessPartnershipsDAO {

	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	boolean result = false;

	public boolean insert(BusinessPartnershipsBean BusinessPartnershipsBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO `businessPartnerships`(`businessPartnershipsId`, "
					+ "`domain`, `query`, `name`, `emailId`, `contactNumber`) VALUES (?,?,?,?,?,?)";
			try {

				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, BusinessPartnershipsBean.getBusinessPartnershipsId());
				pstmt.setString(2, BusinessPartnershipsBean.getDomain());
				pstmt.setString(3, BusinessPartnershipsBean.getQuery());
				pstmt.setString(4, BusinessPartnershipsBean.getName());
				pstmt.setString(5, BusinessPartnershipsBean.getEmailId());
				pstmt.setString(6, BusinessPartnershipsBean.getContactNumber());

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

	public ArrayList<BusinessPartnershipsBean> getList() {
		ArrayList<BusinessPartnershipsBean> list = new ArrayList<BusinessPartnershipsBean>();
		String sql = "select * from businessPartnerships";
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				BusinessPartnershipsBean businessPartnershipsBean = null;
				while (rs.next()) {
					businessPartnershipsBean = new BusinessPartnershipsBean();
					businessPartnershipsBean.setBusinessPartnershipsId(rs.getString("businessPartnershipsId"));
					businessPartnershipsBean.setDomain(rs.getString("domain"));
					businessPartnershipsBean.setContactNumber(rs.getString("contactNumber"));
					businessPartnershipsBean.setEmailId(rs.getString("emailId"));
					businessPartnershipsBean.setName(rs.getString("name"));
					businessPartnershipsBean.setQuery(rs.getString("query"));
					list.add(businessPartnershipsBean);
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

	public boolean delete(String BusinessPartnershipsId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM businessPartnerships WHERE businessPartnershipsId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, BusinessPartnershipsId);

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
