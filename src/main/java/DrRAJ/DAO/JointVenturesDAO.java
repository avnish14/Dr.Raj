package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DrRAJ.Bean.JointVenturesBean;
import DrRAJ.Utils.DBConnection;

public class JointVenturesDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(JointVenturesBean jointVenturesBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO jointventures(id,name,imageLink,forwardLink)" + " values(?,?,?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, jointVenturesBean.getId());
				pstmt.setString(2, jointVenturesBean.getName());
				pstmt.setString(3, jointVenturesBean.getImageLink());
				pstmt.setString(4, jointVenturesBean.getForwardLink());
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

	public List<JointVenturesBean> getList() {

		List<JointVenturesBean> listOfJointVentures = new ArrayList<JointVenturesBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from jointventures  order by name";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				JointVenturesBean jointVentures = null;
				while (rs.next()) {
					jointVentures = new JointVenturesBean();
					jointVentures.setId(rs.getString("id"));
					jointVentures.setName(rs.getString("name"));
					jointVentures.setImageLink(rs.getString("imageLink"));
					jointVentures.setForwardLink(rs.getString("forwardLink"));
					listOfJointVentures.add(jointVentures);
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

		return listOfJointVentures;

	}

	public HashMap<String, JointVenturesBean> getListMap() {

		HashMap<String, JointVenturesBean> map = new HashMap<String, JointVenturesBean>();
		connection = DBConnection.getConnection();
		if (connection != null) {
			String selectSQL = "Select * from jointventures order by name";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				JointVenturesBean jointVentures = null;
				while (rs.next()) {
					jointVentures = new JointVenturesBean();
					jointVentures.setId(rs.getString("id"));
					jointVentures.setName(rs.getString("name"));
					jointVentures.setImageLink(rs.getString("imageLink"));
					jointVentures.setForwardLink(rs.getString("forwardLink"));
					map.put(jointVentures.getForwardLink(), jointVentures);
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

		return map;

	}

	public boolean delete(String id) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM jointventures WHERE id=?";

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

	public JointVenturesBean getByPK(String id) {

		connection = DBConnection.getConnection();
		JointVenturesBean jointVentures = new JointVenturesBean();

		if (connection != null) {
			String selectSQL = "Select * from jointventures  ype WHERE id=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					jointVentures.setId(rs.getString("id"));
					jointVentures.setName(rs.getString("name"));
					jointVentures.setImageLink(rs.getString("imageLink"));
					jointVentures.setForwardLink(rs.getString("forwardLink"));
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
		return jointVentures;
	}

	public boolean update(JointVenturesBean jointVenturesBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE jointventures set name=?,imageLink=?,forwardLink=? WHERE id=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, jointVenturesBean.getName());
				pstmt.setString(2, jointVenturesBean.getImageLink());
				pstmt.setString(3, jointVenturesBean.getForwardLink());
				pstmt.setString(4, jointVenturesBean.getId());

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
