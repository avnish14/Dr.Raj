package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.JointVenturesDetailsBean;
import DrRAJ.Utils.DBConnection;

public class JointVenturesDetailsDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(JointVenturesDetailsBean jointVenturesDetailsBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO jointventuresdetails(id,title,imageLink,content,jointVenturesId)"
					+ " values(?,?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, jointVenturesDetailsBean.getId());
				pstmt.setString(2, jointVenturesDetailsBean.getTitle());
				pstmt.setString(3, jointVenturesDetailsBean.getImageLink());
				pstmt.setString(4, jointVenturesDetailsBean.getContent());
				pstmt.setString(5, jointVenturesDetailsBean.getJointVenturesId());
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

	public List<JointVenturesDetailsBean> getList() {

		List<JointVenturesDetailsBean> listOfJointVenturesDetails = new ArrayList<JointVenturesDetailsBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from jointventuresdetails jvd, jointventures jv where jvd.jointVenturesId=jv.id  order by title";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				JointVenturesDetailsBean jointVenturesDetails = null;
				while (rs.next()) {
					jointVenturesDetails = new JointVenturesDetailsBean();
					jointVenturesDetails.setId(rs.getString("id"));
					jointVenturesDetails.setTitle(rs.getString("title"));
					jointVenturesDetails.setImageLink(rs.getString("imageLink"));
					jointVenturesDetails.setContent(rs.getString("content"));
					jointVenturesDetails.setJointVenturesId(rs.getString("jointVenturesId"));
					jointVenturesDetails.setJointVenturesName(rs.getString("name"));
					listOfJointVenturesDetails.add(jointVenturesDetails);
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

		return listOfJointVenturesDetails;

	}

	public boolean delete(String id) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM jointventuresdetails WHERE id=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, id);

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

	public JointVenturesDetailsBean getByPK(String id) {

		connection = DBConnection.getConnection();
		JointVenturesDetailsBean jointVenturesDetails = new JointVenturesDetailsBean();

		if (connection != null) {
			String selectSQL = "Select * from jointventuresdetails jvd, jointventures jv where jvd.jointVenturesId=jv.id and jvd.id=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					jointVenturesDetails.setId(rs.getString("jvd.id"));
					jointVenturesDetails.setTitle(rs.getString("title"));
					jointVenturesDetails.setImageLink(rs.getString("imageLink"));
					jointVenturesDetails.setContent(rs.getString("content"));
					jointVenturesDetails.setJointVenturesId(rs.getString("jointVenturesId"));
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
		return jointVenturesDetails;
	}

	
	public ArrayList<JointVenturesDetailsBean> getList(String jointVenturesId) {

		ArrayList<JointVenturesDetailsBean> list = new ArrayList<JointVenturesDetailsBean>();
		connection = DBConnection.getConnection();
		JointVenturesDetailsBean jointVenturesDetails = null;

		if (connection != null) {
			String selectSQL = "Select * from jointventuresdetails jvd, jointventures jv where jvd.jointVenturesId=jv.id and jvd.jointVenturesId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, jointVenturesId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					jointVenturesDetails = new JointVenturesDetailsBean();
					jointVenturesDetails.setId(rs.getString("jvd.id"));
					jointVenturesDetails.setTitle(rs.getString("title"));
					jointVenturesDetails.setImageLink(rs.getString("imageLink"));
					jointVenturesDetails.setContent(rs.getString("content"));
					jointVenturesDetails.setJointVenturesId(rs.getString("jointVenturesId"));
					list.add(jointVenturesDetails);
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
		return list;
	}

	
	public boolean update(JointVenturesDetailsBean jointVenturesDetailsBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE jointventuresdetails set title=?,imageLink=?,content=?,jointVenturesId=? WHERE id=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, jointVenturesDetailsBean.getTitle());
				pstmt.setString(2, jointVenturesDetailsBean.getImageLink());
				pstmt.setString(3, jointVenturesDetailsBean.getContent());
				pstmt.setString(4, jointVenturesDetailsBean.getJointVenturesId());
				pstmt.setString(5, jointVenturesDetailsBean.getId());
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
