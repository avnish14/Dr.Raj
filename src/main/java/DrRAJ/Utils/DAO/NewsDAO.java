package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.NewsBean;
import DrRAJ.Utils.DBConnection;

public class NewsDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(NewsBean newsBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO news(newsId,photoLink,content,title)" + " values(?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, newsBean.getNewsId());
				pstmt.setString(2, newsBean.getPhotoLink());
				pstmt.setString(3, newsBean.getContent());
				pstmt.setString(4, newsBean.getTitle());
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

	public List<NewsBean> getList() {

		List<NewsBean> listOfNews = new ArrayList<NewsBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from news";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				NewsBean news = null;
				while (rs.next()) {
					news = new NewsBean();

					news.setNewsId(rs.getString("newsId"));
					news.setPhotoLink(rs.getString("photoLink"));
					news.setContent(rs.getString("content"));
					news.setTitle(rs.getString("title"));
					listOfNews.add(news);
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

		return listOfNews;

	}

	public boolean delete(String newsId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM news WHERE newsId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, newsId);

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

	public NewsBean getByPK(String newsId) {

		connection = DBConnection.getConnection();
		NewsBean news = new NewsBean();

		if (connection != null) {
			String selectSQL = "Select * from news WHERE newsId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, newsId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					news.setNewsId(rs.getString("newsId"));
					news.setPhotoLink(rs.getString("photoLink"));
					news.setContent(rs.getString("content"));
					news.setTitle(rs.getString("title"));
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
		return news;
	}

	public boolean update(NewsBean newsBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE news set photoLink=?,content=?,title=? WHERE newsId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(1, newsBean.getPhotoLink());
				pstmt.setString(2, newsBean.getContent());
				pstmt.setString(3, newsBean.getTitle());
				pstmt.setString(4, newsBean.getNewsId());
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
