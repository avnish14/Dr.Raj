package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.AdminBean;
import DrRAJ.Utils.DBConnection;
import DrRAJ.Utils.GenrateMathodsUtils;

public class AdminDAO {

	Connection conn;
	PreparedStatement pstmt;

	public boolean isEmailExists(String emailId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "Select * from admin where adminEmail=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, emailId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
					return true;

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
		return false;
	}

	public AdminBean login(String adminEmail, String adminPassword) {
		Connection connection;
		String sql = "select * from admin where adminEmail=? and password=?";
		connection = DBConnection.getConnection();
		AdminBean admin = null;
		if (connection != null) {
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, adminEmail);
				pstmt.setString(2, GenrateMathodsUtils.makeSHA512(adminPassword));
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					admin = new AdminBean();
					admin.setAdminId(rs.getString("adminId"));
					admin.setEmailId(rs.getString("adminEmail"));
					admin.setFirstName(rs.getString("adminFirstName"));
					admin.setLastName(rs.getString("adminLastName"));
				}
			} catch (SQLException e) {
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
		return admin;
	}

	public boolean insert(AdminBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "insert into admin(adminId,adminFirstName,adminLastName,adminEmail,password) values(?,?,?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, bean.getAdminId());
				statement.setString(2, bean.getFirstName());
				statement.setString(3, bean.getLastName());
				statement.setString(4, bean.getEmailId());
				statement.setString(5, bean.getPassword());

				int row = statement.executeUpdate();

				if (row != 0)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

	public ArrayList<AdminBean> select() {
		ArrayList<AdminBean> list = new ArrayList<AdminBean>();
		conn = (Connection) DBConnection.getConnection();

		if (conn != null) {
			String sql = "select * from admin";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				AdminBean bean = new AdminBean();
				while (rs.next()) {
					bean = new AdminBean();
					bean.setAdminId(rs.getString("adminId"));
					bean.setEmailId(rs.getString("adminEmail"));
					bean.setFirstName(rs.getString("adminFirstName"));
					bean.setLastName(rs.getString("adminLastName"));

					list.add(bean);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public boolean delete(String adminId) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "delete from admin where adminId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, adminId);
				int row = statement.executeUpdate();

				if (row != 0) {
					return true;
				}

			} catch (Exception e) {

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	public AdminBean getByPK(String adminId) {

		AdminBean bean = new AdminBean();

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from admin where adminId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, adminId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					bean = new AdminBean();
					bean.setAdminId(rs.getString("adminId"));
					bean.setEmailId(rs.getString("adminEmail"));
					bean.setFirstName(rs.getString("adminFirstName"));
					bean.setLastName(rs.getString("adminLastName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	public boolean update(AdminBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "update admin set adminFirstName=? , adminLastName=? ,adminEmail= ? where adminId=?";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, bean.getFirstName());
				statement.setString(2, bean.getLastName());
				statement.setString(3, bean.getEmailId());
				statement.setString(4, bean.getAdminId());

				int row = statement.executeUpdate();

				if (row != 0)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

}
