package DrRAJ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DrRAJ.Bean.SubBlogBean;
import DrRAJ.Utils.DBConnection;

public class SubBlogDAO {

	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	boolean result = false;

	public boolean insert(SubBlogBean SubBlogBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO subblog(subBlogId,blogId,title,content) values(?,?,?,?)";
			try {

				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, SubBlogBean.getSubBlogId());
				pstmt.setString(2, SubBlogBean.getBlogId());
				pstmt.setString(3, SubBlogBean.getTitle());
				pstmt.setString(4, SubBlogBean.getContent());

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

	public ArrayList<SubBlogBean> getList() {
		ArrayList<SubBlogBean> list = new ArrayList<SubBlogBean>();
		String sql = "select * from subblog,blog where subblog.blogId=blog.blogId";
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				SubBlogBean subBlogBean = null;
				while (rs.next()) {
					subBlogBean = new SubBlogBean();
					subBlogBean.setSubBlogId(rs.getString("subBlogId"));
					subBlogBean.setBlogId(rs.getString("blogId"));
					subBlogBean.setBlogTitle(rs.getString("blog.title"));
					subBlogBean.setContent(rs.getString("subblog.content"));
					subBlogBean.setTitle(rs.getString("subblog.title"));
					list.add(subBlogBean);
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

	public ArrayList<SubBlogBean> getSubBlogList(String blogId) {
		ArrayList<SubBlogBean> list = new ArrayList<SubBlogBean>();
		String sql = "select * from subblog,blog where subblog.blogId=blog.blogId and blog.blogId=?";
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, blogId);
				rs = pstmt.executeQuery();
				SubBlogBean subBlogBean = null;
				while (rs.next()) {
					subBlogBean = new SubBlogBean();
					subBlogBean.setSubBlogId(rs.getString("subBlogId"));
					subBlogBean.setBlogId(rs.getString("blogId"));
					subBlogBean.setBlogTitle(rs.getString("blog.title"));
					subBlogBean.setContent(rs.getString("subblog.content"));
					subBlogBean.setTitle(rs.getString("subblog.title"));

					list.add(subBlogBean);
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

	public boolean delete(String SubBlogId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM subblog WHERE subBlogId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, SubBlogId);

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

	public SubBlogBean getByPK(String SubBlogId) {

		conn = DBConnection.getConnection();
		SubBlogBean subBlogBean = new SubBlogBean();

		if (conn != null) {
			String selectSQL = "select * from subblog,blog where subblog.blogId=blog.blogId and subBlogId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, SubBlogId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					subBlogBean.setSubBlogId(rs.getString("subBlogId"));
					subBlogBean.setBlogId(rs.getString("blogId"));
					subBlogBean.setBlogTitle(rs.getString("blog.title"));
					subBlogBean.setContent(rs.getString("subblog.content"));
					subBlogBean.setTitle(rs.getString("subblog.title"));
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
		return subBlogBean;
	}

	public boolean update(SubBlogBean SubBlogBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE subblog set title=?,blogId=?,content=? WHERE subBlogId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, SubBlogBean.getTitle());
				pstmt.setString(2, SubBlogBean.getBlogId());
				pstmt.setString(3, SubBlogBean.getContent());
				pstmt.setString(4, SubBlogBean.getSubBlogId());

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
