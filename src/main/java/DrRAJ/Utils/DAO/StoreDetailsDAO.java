package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.StoreDetailsBean;
import DrRAJ.Utils.DBConnection;

public class StoreDetailsDAO {

	Connection conn;

	public boolean insert(StoreDetailsBean bean) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "insert into storedetails(storedetailsId,name,address,contactNumber1,contactNumber2,cityId) values(?,?,?,?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(2, bean.getName());
				statement.setString(3, bean.getAddress());
				statement.setString(4, bean.getContact1());
				statement.setString(5, bean.getContact2());
				statement.setString(6, bean.getCityId());
				statement.setString(1, bean.getStoreId());
				int row = statement.executeUpdate();

				if (row != 0)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

	public ArrayList<StoreDetailsBean> getList() {
		ArrayList<StoreDetailsBean> list = new ArrayList<StoreDetailsBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from storedetails sd,city c,state s where c.cityId=sd.cityId and c.stateId = s.stateId";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				StoreDetailsBean bean = new StoreDetailsBean();
				while (rs.next()) {
					bean = new StoreDetailsBean();
					bean.setName(rs.getString("name"));
					bean.setAddress(rs.getString("address"));
					bean.setCityId(rs.getString("cityId"));
					bean.setCityname(rs.getString("cityname"));
					bean.setContact1(rs.getString("contactNumber1"));
					bean.setContact2(rs.getString("contactNumber2"));
					bean.setStatename(rs.getString("stateName"));
					bean.setStoreId(rs.getString("storeDetailsId"));
					list.add(bean);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public boolean delete(String storeDetailsId) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "delete from storedetails where storeDetailsId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, storeDetailsId);
				int row = statement.executeUpdate();

				if (row != 0) {
					return true;
				}

			} catch (Exception e) {

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	public StoreDetailsBean getByPK(String storeDetailsId) {

		StoreDetailsBean bean = new StoreDetailsBean();

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from storedetails sd,city c,state s where c.cityId=sd.cityId and c.stateId = s.stateId and  storedetailsId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, storeDetailsId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					bean = new StoreDetailsBean();
					bean.setName(rs.getString("name"));
					bean.setAddress(rs.getString("address"));
					bean.setCityId(rs.getString("cityId"));
					bean.setCityname(rs.getString("cityname"));
					bean.setContact1(rs.getString("contactNumber1"));
					bean.setContact2(rs.getString("contactNumber2"));
					bean.setStatename(rs.getString("stateName"));
					bean.setStoreId(rs.getString("storeDetailsId"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	public boolean update(StoreDetailsBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "update storedetails set name=? , address=?,contactNumber1=? ,contactNumber2=? ,cityId=? where storedetailsId=?";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, bean.getName());
				statement.setString(2, bean.getAddress());
				statement.setString(3, bean.getContact1());
				statement.setString(4, bean.getContact2());
				statement.setString(5, bean.getCityId());
				statement.setString(6, bean.getStoreId());

				int row = statement.executeUpdate();

				if (row != 0)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

}
