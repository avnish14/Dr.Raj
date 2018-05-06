package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.IngredientBean;
import DrRAJ.Utils.DBConnection;

public class IngredientDAO {

	Connection conn;

	public boolean insert(IngredientBean bean) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "insert into ingredients(ingredientsId,photoLink,title,description) values(?,?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, bean.getIngredientsId());
				statement.setString(2, bean.getPhotoLink());
				statement.setString(3, bean.getTitle());
				statement.setString(4, bean.getDescription());

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

	//SELECT * FROM `ingredients` ORDER by RAND() LIMIT 10

	public ArrayList<IngredientBean> getRandom() {
		ArrayList<IngredientBean> list = new ArrayList<IngredientBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "SELECT * FROM `ingredients` WHERE photoLink<>'https://farm5.staticflickr.com/4549/38112492805_d2cd62dac5_o_d.png' ORDER by RAND() LIMIT 10";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				IngredientBean bean = new IngredientBean();
				while (rs.next()) {
					bean = new IngredientBean();
					bean.setDescription(rs.getString("description"));
					bean.setIngredientsId(rs.getString("ingredientsId"));
					bean.setPhotoLink(rs.getString("photoLink"));
					bean.setTitle(rs.getString("title"));
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

	
	public ArrayList<IngredientBean> select() {
		ArrayList<IngredientBean> list = new ArrayList<IngredientBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from ingredients order by title";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				IngredientBean bean = new IngredientBean();
				while (rs.next()) {
					bean = new IngredientBean();
					bean.setDescription(rs.getString("description"));
					bean.setIngredientsId(rs.getString("ingredientsId"));
					bean.setPhotoLink(rs.getString("photoLink"));
					bean.setTitle(rs.getString("title"));
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

	public boolean delete(String ingredientId) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "delete from ingredients where ingredientsId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, ingredientId);
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

	public IngredientBean getByPK(String ingredientId) {

		IngredientBean bean = new IngredientBean();

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from ingredients where ingredientsId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, ingredientId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					bean = new IngredientBean();
					bean.setDescription(rs.getString("description"));
					bean.setIngredientsId(rs.getString("ingredientsId"));
					bean.setPhotoLink(rs.getString("photoLink"));
					bean.setTitle(rs.getString("title"));
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

	public boolean update(IngredientBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "update ingredients set photoLink=? , title=?,description=? where ingredientsId=?";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, bean.getPhotoLink());
				statement.setString(2, bean.getTitle());
				statement.setString(3, bean.getDescription());
				statement.setString(4, bean.getIngredientsId());

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
