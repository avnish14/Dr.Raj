package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.ReviewBean;
import DrRAJ.Utils.DBConnection;

public class ReviewDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(ReviewBean reviewBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO review(reviewId, customerName, rating, title, description, isValid, productId)"
					+ " values(?,?,?,?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, reviewBean.getReviewId());
				pstmt.setString(2, reviewBean.getCustomerName());
				pstmt.setInt(3, reviewBean.getRating());
				pstmt.setString(4, reviewBean.getTitle());
				pstmt.setString(5, reviewBean.getDescription());
				pstmt.setString(6, reviewBean.getIsValid());
				pstmt.setString(7, reviewBean.getProductId());
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

	public List<ReviewBean> getList() {

		List<ReviewBean> listOfReview = new ArrayList<ReviewBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from review,product where product.productId=review.productId";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ReviewBean review = null;
				while (rs.next()) {
					review = new ReviewBean();

					review.setReviewId(rs.getString("reviewId"));
					review.setDescription(rs.getString("description"));
					review.setCustomerName(rs.getString("customerName"));
					review.setIsValid(rs.getString("isValid"));
					review.setProductId(rs.getString("productId"));
					review.setProductName(rs.getString("productName"));
					review.setRating(rs.getInt("rating"));
					review.setTitle(rs.getString("title"));
					listOfReview.add(review);
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

		return listOfReview;

	}

	
	public List<ReviewBean> getValidList() {

		List<ReviewBean> listOfReview = new ArrayList<ReviewBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from review,product where product.productId=review.productId and isVaild='1'";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ReviewBean review = null;
				while (rs.next()) {
					review = new ReviewBean();

					review.setReviewId(rs.getString("reviewId"));
					review.setDescription(rs.getString("description"));
					review.setCustomerName(rs.getString("customerName"));
					review.setIsValid(rs.getString("isValid"));
					review.setProductId(rs.getString("productId"));
					review.setProductName(rs.getString("productName"));
					review.setRating(rs.getInt("rating"));
					review.setTitle(rs.getString("title"));
					listOfReview.add(review);
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

		return listOfReview;

	}

	public boolean delete(String reviewId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM review WHERE reviewId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, reviewId);

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

	public ReviewBean getByPK(String reviewId) {

		connection = DBConnection.getConnection();
		ReviewBean review = new ReviewBean();

		if (connection != null) {
			String selectSQL = "Select * from review,product where product.productId=review.productId and reviewId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, reviewId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					review.setReviewId(rs.getString("reviewId"));
					review.setDescription(rs.getString("description"));
					review.setCustomerName(rs.getString("customerName"));
					review.setIsValid(rs.getString("isValid"));
					review.setProductId(rs.getString("productId"));
					review.setProductName(rs.getString("productName"));
					review.setRating(rs.getInt("rating"));
					review.setTitle(rs.getString("title"));
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
		return review;
	}

	public String makeItValid(String reviewId, String value) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE review SET isValid=? WHERE reviewId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setInt(1, Integer.parseInt(value));
				pstmt.setString(2, reviewId);
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0)
					return "1";
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
		return "0";
	}

	public boolean update(ReviewBean reviewBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE review SET customerName=?," + "rating=?,title=?,description=?,isValid=?,"
					+ "productId=? WHERE reviewId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(7, reviewBean.getReviewId());
				pstmt.setString(1, reviewBean.getCustomerName());
				pstmt.setInt(2, reviewBean.getRating());
				pstmt.setString(3, reviewBean.getTitle());
				pstmt.setString(4, reviewBean.getDescription());
				pstmt.setString(5, reviewBean.getIsValid());
				pstmt.setString(6, reviewBean.getProductId());
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
