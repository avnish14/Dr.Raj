package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.TestimonialBean;
import DrRAJ.Utils.DBConnection;

public class TestimonialDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(TestimonialBean testimonialBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO testimonial(testimonialId,photoLink,name,description)" + " values(?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, testimonialBean.getTestimonialId());
				pstmt.setString(2, testimonialBean.getPhotoLink());
				pstmt.setString(3, testimonialBean.getName());
				pstmt.setString(4, testimonialBean.getDescription());
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

	public List<TestimonialBean> getList() {

		List<TestimonialBean> listOfTestimonial = new ArrayList<TestimonialBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from testimonial";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				TestimonialBean testimonial = null;
				while (rs.next()) {
					testimonial = new TestimonialBean();

					testimonial.setTestimonialId(rs.getString("testimonialId"));
					testimonial.setDescription(rs.getString("description"));
					testimonial.setPhotoLink(rs.getString("photoLink"));
					testimonial.setName(rs.getString("name"));
					listOfTestimonial.add(testimonial);
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

		return listOfTestimonial;

	}

	public boolean isTestimonialExists(String testimonialName) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from testimonial where name=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, testimonialName);
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

	public boolean delete(String testimonialId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM testimonial WHERE testimonialId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, testimonialId);

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

	public TestimonialBean getByPK(String testimonialId) {

		connection = DBConnection.getConnection();
		TestimonialBean testimonial = new TestimonialBean();

		if (connection != null) {
			String selectSQL = "Select * from testimonial WHERE testimonialId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, testimonialId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					testimonial.setTestimonialId(rs.getString("testimonialId"));
					testimonial.setDescription(rs.getString("description"));
					testimonial.setPhotoLink(rs.getString("photoLink"));
					testimonial.setName(rs.getString("name"));
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
		return testimonial;
	}

	public boolean update(TestimonialBean testimonialBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE testimonial set photoLink=?,name=?,description=? WHERE testimonialId=?";
			try {
				pstmt = connection.prepareStatement(updateSQL);
				pstmt.setString(1, testimonialBean.getPhotoLink());
				pstmt.setString(2, testimonialBean.getName());
				pstmt.setString(3, testimonialBean.getDescription());
				pstmt.setString(4, testimonialBean.getTestimonialId());
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
