package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.BookKeywordBean;
import DrRAJ.Utils.DBConnection;
import DrRAJ.Utils.GenrateMathodsUtils;

public class BookKeywordDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(BookKeywordBean bean) {
		String temp[] = bean.getKeyword().split("=");
		for (int i = 0; i < temp.length; i++) {
			connection = DBConnection.getConnection();
			if (connection != null) {
				String insertSQL = "INSERT INTO bookkeyword(keyword,bookId,bookkeywordId)" + " values(?,?,?)";
				try {
					connection.setAutoCommit(false);
					pstmt = connection.prepareStatement(insertSQL);
					pstmt.setString(1, temp[i]);
					pstmt.setString(2, bean.getBookId());
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

	public List<BookKeywordBean> getList() {

		List<BookKeywordBean> listOfBookKeyword = new ArrayList<BookKeywordBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from bookkeyword bk,book b where b.bookId=bk.bookId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				BookKeywordBean bookKeyword = null;
				while (rs.next()) {
					bookKeyword = new BookKeywordBean();

					bookKeyword.setAuthor(rs.getString("author"));
					bookKeyword.setBookId(rs.getString("bookId"));
					bookKeyword.setBookName(rs.getString("name"));
					bookKeyword.setIsbn(rs.getString("isbn"));
					bookKeyword.setKeyword(rs.getString("keyword"));
					bookKeyword.setBookKeywordId(rs.getString("bookKeywordId"));

					listOfBookKeyword.add(bookKeyword);
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

		return listOfBookKeyword;

	}

	public boolean delete(String bookId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM bookkeyword WHERE bookkeywordId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, bookId);

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

	public BookKeywordBean getByPK(String bookKeywordId) {

		connection = DBConnection.getConnection();
		BookKeywordBean bookKeywordBean = new BookKeywordBean();

		if (connection != null) {
			String selectSQL = "Select * from bookKeyword WHERE bookKeywordId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, bookKeywordId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					bookKeywordBean.setBookId(rs.getString("bookId"));
					bookKeywordBean.setKeyword(rs.getString("keyword"));
					bookKeywordBean.setBookKeywordId(rs.getString("bookkeywordId"));
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
		return bookKeywordBean;
	}

	public boolean update(BookKeywordBean bookKeywordBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE bookkeyword set keyword=?,bookId=? WHERE bookKeywordId=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, bookKeywordBean.getKeyword());
				pstmt.setString(2, bookKeywordBean.getBookId());
				pstmt.setString(3, bookKeywordBean.getBookKeywordId());

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
