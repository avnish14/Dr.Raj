package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.ContactUsBean;
import DrRAJ.Utils.DBConnection;

public class ContactUsDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(ContactUsBean contactUsBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO contactus(contactUsId,name,emailId,query)" + " values(?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, contactUsBean.getContactUsId());
				pstmt.setString(2, contactUsBean.getName());
				pstmt.setString(3, contactUsBean.getEmailId());
				pstmt.setString(4, contactUsBean.getQuery());
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

	public ArrayList<ContactUsBean> getList() {

		List<ContactUsBean> listOfContactUs = new ArrayList<ContactUsBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from contactus";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ContactUsBean contactUs = null;
				while (rs.next()) {
					contactUs = new ContactUsBean();

					contactUs.setContactUsId(rs.getString("contactUsId"));
					contactUs.setName(rs.getString("name"));
					contactUs.setEmailId(rs.getString("emailId"));
					contactUs.setQuery(rs.getString("query"));
					listOfContactUs.add(contactUs);
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

		return (ArrayList<ContactUsBean>) listOfContactUs;

	}

	public boolean delete(String contactUsId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM contactus WHERE contactUsId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, contactUsId);

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

	public ContactUsBean getByPK(String contactUsId) {

		connection = DBConnection.getConnection();
		ContactUsBean contactUs = new ContactUsBean();

		if (connection != null) {
			String selectSQL = "Select * from contactus WHERE contactUsId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, contactUsId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					contactUs.setContactUsId(rs.getString("contactUsId"));
					contactUs.setName(rs.getString("name"));
					contactUs.setEmailId(rs.getString("emailId"));
					contactUs.setQuery(rs.getString("query"));
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
		return contactUs;
	}

	
}
