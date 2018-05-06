package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.PressInfoBean;
import DrRAJ.Utils.DBConnection;

public class PressInfoDAO {

	Connection conn;

	public boolean insert(PressInfoBean bean) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "insert into pressinfo(pressInfoId,typeId,title,link) values(?,?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, bean.getPressInfoId());
				statement.setString(2, bean.getTypeId());
				statement.setString(3, bean.getTitle());
				statement.setString(4, bean.getLink());

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

	public ArrayList<PressInfoBean> getList() {
		ArrayList<PressInfoBean> list = new ArrayList<PressInfoBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from pressinfo pi,pressInfoType pt where pt.typeId=pi.typeId";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				PressInfoBean bean = new PressInfoBean();
				while (rs.next()) {
					bean = new PressInfoBean();
					bean.setLink(rs.getString("link"));
					bean.setPressInfoId(rs.getString("pressInfoId"));
					bean.setPressTypeName(rs.getString("name"));
					bean.setTitle(rs.getString("title"));
					bean.setTypeId(rs.getString("typeID"));
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

	public boolean delete(String pressInfoId) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "delete from pressinfo where pressInfoId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, pressInfoId);
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

	public PressInfoBean getByPK(String pressInfoId) {

		PressInfoBean bean = new PressInfoBean();

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from pressinfo pi,pressInfoType pt where pt.typeId=pi.typeId and pressInfoId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, pressInfoId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					bean = new PressInfoBean();
					bean.setLink(rs.getString("link"));
					bean.setPressInfoId(rs.getString("pressInfoId"));
					bean.setPressTypeName(rs.getString("name"));
					bean.setTitle(rs.getString("title"));
					bean.setTypeId(rs.getString("typeID"));
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

	public boolean update(PressInfoBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "update pressinfo set title=?,typeId=?,link=? where pressInfoId=?";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, bean.getTitle());
				statement.setString(2, bean.getTypeId());
				statement.setString(3, bean.getLink());
				statement.setString(4, bean.getPressInfoId());

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
