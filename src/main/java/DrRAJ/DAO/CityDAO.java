package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.CityBean;
import DrRAJ.Utils.DBConnection;

public class CityDAO {

	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	boolean result = false;

	public boolean insert(CityBean CityBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO city(cityName,cityId,stateId) values(?,?,?)";
			try {

				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, CityBean.getCityName());
				pstmt.setString(2, CityBean.getCityId());
				pstmt.setString(3, CityBean.getStateId());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	public ArrayList<CityBean> getList() {
		ArrayList<CityBean> list = new ArrayList<CityBean>();
		String sql = "select * from city,state where city.stateId=state.stateId order by city.cityName";
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				CityBean cityBean = null;
				while (rs.next()) {
					cityBean = new CityBean();
					cityBean.setCityId(rs.getString("cityId"));
					cityBean.setCityName(rs.getString("cityName"));
					cityBean.setStateName(rs.getString("stateName"));
					cityBean.setStateId(rs.getString("stateId"));
					list.add(cityBean);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}

	public ArrayList<CityBean> getCityList(String stateName) {
		ArrayList<CityBean> list = new ArrayList<CityBean>();
		String sql = "select * from city,state where city.stateId=state.stateId and city.stateName=? order by city.cityName";
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, stateName);
				rs = pstmt.executeQuery();
				CityBean cityBean = null;
				while (rs.next()) {
					cityBean = new CityBean();
					cityBean.setCityId(rs.getString("cityId"));
					cityBean.setCityName(rs.getString("cityName"));
					cityBean.setStateName(rs.getString("stateName"));
					cityBean.setStateId(rs.getString("stateId"));
					list.add(cityBean);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	public boolean delete(String CityId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM city WHERE cityId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, CityId);

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}

	public CityBean getByPK(String CityId) {

		conn = DBConnection.getConnection();
		CityBean cityBean = new CityBean();

		if (conn != null) {
			String selectSQL = "select * from city,state where city.stateId=state.stateId and cityId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, CityId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					cityBean.setCityId(rs.getString("cityId"));
					cityBean.setCityName(rs.getString("cityName"));
					cityBean.setStateName(rs.getString("stateName"));
					cityBean.setStateId(rs.getString("stateId"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cityBean;
	}

	public boolean update(CityBean CityBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE city set cityName=?,stateId=? WHERE cityId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, CityBean.getCityName());
				pstmt.setString(2, CityBean.getStateId());
				pstmt.setString(3, CityBean.getCityId());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
				} else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
