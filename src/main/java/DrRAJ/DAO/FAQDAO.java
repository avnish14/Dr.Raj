package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.FAQBean;
import DrRAJ.Utils.DBConnection;

public class FAQDAO {

	Connection conn;

	public boolean insert(FAQBean bean) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "insert into faq(faqId,question,answer) values(?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, bean.getFaqId());
				statement.setString(2, bean.getQuestion());
				statement.setString(3, bean.getAnswer());

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

	public ArrayList<FAQBean> select() {
		ArrayList<FAQBean> list = new ArrayList<FAQBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from faq";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				FAQBean bean = new FAQBean();
				while (rs.next()) {
					bean = new FAQBean();
					bean.setAnswer(rs.getString("answer"));
					bean.setQuestion(rs.getString("question"));
					bean.setFaqId(rs.getString("faqid"));
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

	public boolean delete(String faqId) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "delete from faq where faqId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, faqId);
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

	public FAQBean getByPK(String faqId) {

		FAQBean bean = new FAQBean();

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from faq where faqId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, faqId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					bean = new FAQBean();
					bean.setAnswer(rs.getString("answer"));
					bean.setQuestion(rs.getString("question"));
					bean.setFaqId(rs.getString("faqId"));
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

	public boolean update(FAQBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "update faq set question=? , answer=? where faqId=?";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, bean.getQuestion());
				statement.setString(2, bean.getAnswer());
				statement.setString(3, bean.getFaqId());

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
