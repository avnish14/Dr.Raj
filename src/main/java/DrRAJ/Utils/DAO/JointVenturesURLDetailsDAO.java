
package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.JointventuresURLDetailsBean;
import DrRAJ.Utils.DBConnection;

public class JointVenturesURLDetailsDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(JointventuresURLDetailsBean jointventuresURLDetailsBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO jointventuresurldetails(id,subTitle,content,pdfLink,pdfName,jointVenturesId)"
					+ " values(?,?,?,?,?,?)";
			try {
				System.out.println("Helloooooooooooo");
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, jointventuresURLDetailsBean.getId());
				pstmt.setString(2, jointventuresURLDetailsBean.getSubTitle());
				pstmt.setString(3, jointventuresURLDetailsBean.getContent());
				pstmt.setString(4, jointventuresURLDetailsBean.getPdfLink());
				pstmt.setString(5, jointventuresURLDetailsBean.getPdfName());
				pstmt.setString(6, jointventuresURLDetailsBean.getJointVenturesId());
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

	public List<JointventuresURLDetailsBean> getList() {

		List<JointventuresURLDetailsBean> listOfJointventuresURLDetails = new ArrayList<JointventuresURLDetailsBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from jointventuresurldetails jvd, jointventures jv where jvd.jointVenturesId=jv.id  order by subTitle";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				JointventuresURLDetailsBean jointventuresURLDetails = null;
				while (rs.next()) {
					jointventuresURLDetails = new JointventuresURLDetailsBean();
					jointventuresURLDetails.setId(rs.getString("id"));
					jointventuresURLDetails.setSubTitle(rs.getString("subTitle"));
					jointventuresURLDetails.setPdfLink(rs.getString("pdfLink"));
					jointventuresURLDetails.setPdfName(rs.getString("pdfName"));
					jointventuresURLDetails.setContent(rs.getString("content"));
					jointventuresURLDetails.setJointVenturesId(rs.getString("jointVenturesId"));
					jointventuresURLDetails.setJointVenturesName(rs.getString("name"));
					listOfJointventuresURLDetails.add(jointventuresURLDetails);
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

		return listOfJointventuresURLDetails;

	}

	public boolean delete(String id) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM jointventuresurldetails WHERE id=?";

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

	public JointventuresURLDetailsBean getByPK(String id) {

		connection = DBConnection.getConnection();
		JointventuresURLDetailsBean jointventuresURLDetails = new JointventuresURLDetailsBean();

		if (connection != null) {
			String selectSQL = "Select * from jointventuresurldetails jvd, jointventures jv where jvd.jointVenturesId=jv.id and jvd.id=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					jointventuresURLDetails.setId(rs.getString("id"));
					jointventuresURLDetails.setSubTitle(rs.getString("subTitle"));
					jointventuresURLDetails.setPdfLink(rs.getString("pdfLink"));
					jointventuresURLDetails.setPdfName(rs.getString("pdfName"));
					jointventuresURLDetails.setContent(rs.getString("content"));
					jointventuresURLDetails.setJointVenturesId(rs.getString("jointVenturesId"));
					jointventuresURLDetails.setJointVenturesName(rs.getString("name"));
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
		return jointventuresURLDetails;
	}

	public ArrayList<JointventuresURLDetailsBean> getDetails(String jointVentureId) {
		ArrayList<JointventuresURLDetailsBean> list = new ArrayList<JointventuresURLDetailsBean>();
		connection = DBConnection.getConnection();
		JointventuresURLDetailsBean jointventuresURLDetails = null;

		if (connection != null) {
			String selectSQL = "Select * from jointventuresurldetails jvd, jointventures jv where jvd.jointVenturesId=jv.id and jvd.jointVenturesId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, jointVentureId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					jointventuresURLDetails = new JointventuresURLDetailsBean();
					jointventuresURLDetails.setId(rs.getString("id"));
					jointventuresURLDetails.setSubTitle(rs.getString("subTitle"));
					jointventuresURLDetails.setPdfLink(rs.getString("pdfLink"));
					jointventuresURLDetails.setPdfName(rs.getString("pdfName"));
					jointventuresURLDetails.setContent(rs.getString("content"));
					jointventuresURLDetails.setJointVenturesId(rs.getString("jointVenturesId"));
					jointventuresURLDetails.setJointVenturesName(rs.getString("name"));
					list.add(jointventuresURLDetails);
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

	public boolean update(JointventuresURLDetailsBean jointventuresURLDetailsBean) {
		connection = DBConnection.getConnection();
		System.out.println(jointventuresURLDetailsBean.getJointVenturesId() + "ID");
		if (connection != null) {
			String updateSQL = "UPDATE jointventuresurldetails set subTitle=?,pdfLink=?,pdfName=?,content=?,jointVenturesId=? WHERE id=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, jointventuresURLDetailsBean.getSubTitle());
				pstmt.setString(2, jointventuresURLDetailsBean.getPdfLink());
				pstmt.setString(3, jointventuresURLDetailsBean.getPdfName());
				pstmt.setString(4, jointventuresURLDetailsBean.getContent());
				pstmt.setString(5, jointventuresURLDetailsBean.getJointVenturesId());
				pstmt.setString(6, jointventuresURLDetailsBean.getId());
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Hi");
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
