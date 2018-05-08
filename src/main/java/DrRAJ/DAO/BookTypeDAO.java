package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import DrRAJ.Bean.BookTypeBean;
import DrRAJ.Utils.DBConnection;

public class BookTypeDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(BookTypeBean bookTypeBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO booktype(typeId,name)" + " values(?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, bookTypeBean.getTypeId());
				pstmt.setString(2, bookTypeBean.getName());
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

	public List<BookTypeBean> getList() {

		List<BookTypeBean> listOfBookType = new ArrayList<BookTypeBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from booktype order by name";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				BookTypeBean bookType = null;
				while (rs.next()) {
					bookType = new BookTypeBean();

					bookType.setTypeId(rs.getString("typeId"));
					bookType.setName(rs.getString("name"));
					listOfBookType.add(bookType);
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

		return listOfBookType;

	}

	public boolean isBookTypeExists(String bookTypeName) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from booktype where name=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, bookTypeName);
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

	public boolean delete(String BookTypeId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM booktype WHERE typeId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, BookTypeId);

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

	public BookTypeBean getByPK(String bookTypeId) {

		connection = DBConnection.getConnection();
		BookTypeBean bookType = new BookTypeBean();

		if (connection != null) {
			String selectSQL = "Select * from booktype WHERE typeId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, bookTypeId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					bookType.setTypeId(rs.getString("typeId"));
					bookType.setName(rs.getString("name"));

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
		return bookType;
	}

	public boolean update(BookTypeBean bookTypeBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE booktype set name=? WHERE typeId=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, bookTypeBean.getName());
				pstmt.setString(2, bookTypeBean.getTypeId());

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

	public HashSet<String> getTypes(String category) {
		HashSet<String> types = new HashSet<String>();
		if (category.equals("Mind,Body & Spirit")) {
			types.add("'Yoga'".toUpperCase());
			types.add("'Buddhism Meditation'".toUpperCase());
			types.add("'Chakras Kundalini'".toUpperCase());
			types.add("'Eating Disorder'".toUpperCase());
			types.add("'Psychology Relationship'".toUpperCase());
			types.add("'Spiritual Philosophy'".toUpperCase());
		} else if(category.equals("Homeopathic Self-Help")) {
			types.add("'For Beginners'".toUpperCase());
			types.add("'Children'".toUpperCase());
			types.add("'First Aid Acutes'".toUpperCase());
			types.add("'General'".toUpperCase());
			types.add("'Homoeopathic Research'".toUpperCase());
			types.add("'Therapeutics'".toUpperCase());
		}

		return types;

	}
	
}
