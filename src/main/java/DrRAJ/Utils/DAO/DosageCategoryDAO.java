package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.DosageCategoryBean;
import DrRAJ.Utils.DBConnection;

public class DosageCategoryDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(DosageCategoryBean dosageCategoryBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO dosagecategory(dosageCategoryId,name)" + " values(?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, dosageCategoryBean.getDosageCategoryid());
				pstmt.setString(2, dosageCategoryBean.getDosageCategoryName());
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

	public List<DosageCategoryBean> getList() {

		List<DosageCategoryBean> listOfDosageCategory = new ArrayList<DosageCategoryBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from dosagecategory order by name";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				DosageCategoryBean dosageCategory = null;
				while (rs.next()) {
					dosageCategory = new DosageCategoryBean();

					dosageCategory.setDosageCategoryid(rs.getString("dosageCategoryId"));
					dosageCategory.setDosageCategoryName(rs.getString("name"));
					listOfDosageCategory.add(dosageCategory);
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

		return listOfDosageCategory;

	}

	public boolean isDosageCategoryExists(String dosageCategoryName) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from dosagecategory where name=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, dosageCategoryName);
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

	public boolean delete(String dosageCategoryId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM dosagecategory WHERE dosageCategoryId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, dosageCategoryId);

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

	public DosageCategoryBean getByPK(String productCategoryId) {

		connection = DBConnection.getConnection();
		DosageCategoryBean dosageCategory = new DosageCategoryBean();

		if (connection != null) {
			String selectSQL = "Select * from dosagecategory WHERE dosageCategoryId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, productCategoryId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					dosageCategory.setDosageCategoryid(rs.getString("dosageCategoryId"));
					dosageCategory.setDosageCategoryName(rs.getString("name"));
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
		return dosageCategory;
	}

	public boolean update(DosageCategoryBean dosageCategoryBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE dosagecategory set name=? WHERE dosageCategoryId=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, dosageCategoryBean.getDosageCategoryName());
				pstmt.setString(2, dosageCategoryBean.getDosageCategoryid());

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
