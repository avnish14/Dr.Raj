package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.CompanyManagementBean;
import DrRAJ.Utils.DBConnection;

public class CompanyManagementDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(CompanyManagementBean companyManagementBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO companymanagement(companyManagementId,photoLink,name,title)"
					+ " values(?,?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, companyManagementBean.getCompanyManagementId());
				pstmt.setString(2, companyManagementBean.getPhotoLink());
				pstmt.setString(3, companyManagementBean.getName());
				pstmt.setString(4, companyManagementBean.getTitle());
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

	public List<CompanyManagementBean> getList() {

		List<CompanyManagementBean> listOfCompanyManagement = new ArrayList<CompanyManagementBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from companymanagement";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				CompanyManagementBean companyManagement = null;
				while (rs.next()) {
					companyManagement = new CompanyManagementBean();

					companyManagement.setCompanyManagementId(rs.getString("companyManagementId"));
					companyManagement.setPhotoLink(rs.getString("photoLink"));
					companyManagement.setName(rs.getString("name"));
					companyManagement.setTitle(rs.getString("title"));
					listOfCompanyManagement.add(companyManagement);
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

		return listOfCompanyManagement;

	}

	public boolean delete(String companyManagementId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM companymanagement WHERE companyManagementId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, companyManagementId);

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

	public CompanyManagementBean getByPK(String companyManagementId) {

		connection = DBConnection.getConnection();
		CompanyManagementBean companyManagement = new CompanyManagementBean();

		if (connection != null) {
			String selectSQL = "Select * from companymanagement WHERE companyManagementId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, companyManagementId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					companyManagement.setCompanyManagementId(rs.getString("companyManagementId"));
					companyManagement.setPhotoLink(rs.getString("photoLink"));
					companyManagement.setName(rs.getString("name"));
					companyManagement.setTitle(rs.getString("title"));
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
		return companyManagement;
	}

	public boolean update(CompanyManagementBean companyManagementBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE companymanagement set photoLink=?,name=?,title=? WHERE companyManagementId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(1, companyManagementBean.getPhotoLink());
				pstmt.setString(2, companyManagementBean.getName());
				pstmt.setString(3, companyManagementBean.getTitle());
				pstmt.setString(4, companyManagementBean.getCompanyManagementId());
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
