package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.BlogBean;
import DrRAJ.Bean.BookBean;
import DrRAJ.Utils.DBConnection;

public class BlogDAO {

	Connection conn;

	public boolean insert(BlogBean bean) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "insert into blog(blogId,imageLink,title,date,content,urlLink) values(?,?,?,?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, bean.getBlogId());
				statement.setString(2, bean.getImageLink());
				statement.setString(3, bean.getBlogTitle());
				statement.setString(4, bean.getDate());
				statement.setString(5, bean.getContent());
				statement.setString(6, bean.getUrlLink());

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

	public ArrayList<BlogBean> getList() {
		ArrayList<BlogBean> list = new ArrayList<BlogBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from blog";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				BlogBean bean = new BlogBean();
				while (rs.next()) {
					bean = new BlogBean();
					bean.setContent(rs.getString("content"));
					bean.setBlogId(rs.getString("blogId"));
					bean.setImageLink(rs.getString("imageLink"));
					bean.setBlogTitle(rs.getString("title"));
					bean.setUrlLink(rs.getString("urlLink"));
					bean.setDate(rs.getString("date"));
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

	public boolean delete(String blogId) {

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "delete from blog where blogId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, blogId);
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

	public BlogBean getByPK(String blogId) {

		BlogBean bean = new BlogBean();

		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from blog where blogId=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, blogId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					bean = new BlogBean();
					bean.setContent(rs.getString("content"));
					bean.setBlogId(rs.getString("blogId"));
					bean.setImageLink(rs.getString("imageLink"));
					bean.setBlogTitle(rs.getString("title"));
					bean.setUrlLink(rs.getString("urlLink"));
					bean.setDate(rs.getString("date"));

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
		return bean;
	}

	public boolean isbnIsExists(String isbn) {


		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from book where isbn=?";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, isbn);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					return true;
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
		return false;
	}

	public boolean update(BlogBean bean) {
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "update blog set imageLink=?,title=?,date=?,content=?,urlLink=? where blogId=?";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, bean.getImageLink());
				statement.setString(2, bean.getBlogTitle());
				statement.setString(3, bean.getDate());
				statement.setString(4, bean.getContent());
				statement.setString(5, bean.getUrlLink());
				statement.setString(6, bean.getBlogId());

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

	public ArrayList<BookBean> getBySubtypes(String type) {

		String subtype = new BookTypeDAO().getTypes(type).toString();
		System.out.println(subtype.substring(1, subtype.length() - 1));
		ArrayList<BookBean> list = new ArrayList<BookBean>();
		conn = (Connection) DBConnection.getConnection();
		if (conn != null) {
			String sql = "select * from book where type in (" + subtype.substring(1, subtype.length() - 1) + ")";
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				BookBean bean = new BookBean();
				while (rs.next()) {
					bean = new BookBean();
					bean.setDescription(rs.getString("description"));
					bean.setBookId(rs.getString("bookId"));
					bean.setPhotolink(rs.getString("photoLink"));
					bean.setName(rs.getString("name"));
					bean.setType(rs.getString("type"));
					bean.setUrllink(rs.getString("urlLink"));
					bean.setAuthor(rs.getString("author"));
					bean.setIsbn(rs.getString("isbn"));
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
		System.out.println(list.size());
		return list;

	}

	public static void main(String[] args) {
		new BlogDAO().getBySubtypes("Mind,Body & Spirit");
		new BlogDAO().getBySubtypes("Homeopathic Self-Help");
	}

}
