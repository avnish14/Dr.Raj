package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DrRAJ.Bean.StateBean;
import DrRAJ.Utils.DBConnection;

public class StateDAO {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;

	public boolean insert(StateBean stateBean) {
		connection = DBConnection.getConnection();
		if (connection != null) {
			String insertSQL = "INSERT INTO state(stateId,stateName)" + " values(?,?)";
			try {
				connection.setAutoCommit(false);
				pstmt = connection.prepareStatement(insertSQL);
				pstmt.setString(1, stateBean.getStateId());
				pstmt.setString(2, stateBean.getStateName());
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

	public ArrayList<StateBean> getList() {

		ArrayList<StateBean> listOfState = new ArrayList<StateBean>();
		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from state order by stateName";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				StateBean State = null;
				while (rs.next()) {
					State = new StateBean();

					State.setStateId(rs.getString("stateId"));
					State.setStateName(rs.getString("stateName"));
					listOfState.add(State);
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

		return listOfState;

	}

	public boolean isStateExists(String stateName) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String selectSQL = "Select * from state where stateName=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);
				pstmt.setString(1, stateName);
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

	public boolean delete(String StateId) {

		connection = DBConnection.getConnection();

		if (connection != null) {
			String deleteSQL = "DELETE FROM state WHERE stateId=?";

			try {
				pstmt = connection.prepareStatement(deleteSQL);

				pstmt.setString(1, StateId);

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

	public StateBean getByPK(String StateId) {

		connection = DBConnection.getConnection();
		StateBean State = new StateBean();

		if (connection != null) {
			String selectSQL = "Select * from state WHERE stateId=?";
			try {
				pstmt = connection.prepareStatement(selectSQL);

				pstmt.setString(1, StateId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					State.setStateId(rs.getString("stateId"));
					State.setStateName(rs.getString("stateName"));

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
		return State;
	}

	public boolean update(StateBean stateBean) {
		connection = DBConnection.getConnection();

		if (connection != null) {
			String updateSQL = "UPDATE state set stateName=? WHERE stateId=?";

			try {
				pstmt = connection.prepareStatement(updateSQL);

				pstmt.setString(1, stateBean.getStateName());
				pstmt.setString(2, stateBean.getStateId());

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
