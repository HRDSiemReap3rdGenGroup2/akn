package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.User;
import utilities.DBUtility;

public class UserDAO {
	private Connection con = null;

	public UserDAO() {
		con = new DBUtility().getConnection();
	}

	public ArrayList<User> getAllUser() throws SQLException {
		ArrayList<User> list = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM public.tbluser";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("userid"));
				user.setUser_name(rs.getString("username"));
				user.setUser_pass(rs.getString("password"));
				user.setUser_email(rs.getString("email"));
				user.setUser_type(rs.getInt("usertypeid"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public User login(String username, String password) throws SQLException {
		try {
			String sql = "select * from public.tbluser where email=? and password=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("userid"));
				u.setUser_name(rs.getString("username"));
				u.setUser_type(rs.getInt("usertypeid"));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return null;
	}

	public boolean addUser(User user) throws Exception {
		try {
			String sql = "INSERT INTO public.tbluser(userid, usertypeid, username, password, email, gender) VALUES(nextval('news.seq_user'),2,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, user.getUser_name());
			p.setString(2, user.getUser_pass());
			p.setString(3, user.getUser_email());
			p.setString(4, user.getUser_gender());

			if (p.executeUpdate() > 0)
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public ArrayList<User> getAllUser1() throws SQLException {
		ArrayList<User> list = new ArrayList<User>();
		try {
			String sql = "select userid, username, usertypeid, email, gender, password From public.tbluser";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("userid"));
				user.setUser_name(rs.getString("username"));
				user.setUser_pass(rs.getString("password"));
				user.setUser_type(rs.getInt("usertypeid"));
				user.setUser_gender(rs.getString("gender"));
				user.setUser_email(rs.getString("email"));

				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}
	
	public ArrayList<User> getAllUser2() throws SQLException {
		ArrayList<User> list = new ArrayList<User>();
		try {
			String sql = "select userid, username, usertypename, email, gender, password From public.tbluser u INNER JOIN public.tblusertype t ON u.usertypeid=t.usertypeid";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("userid"));
				user.setUser_name(rs.getString("username"));
				user.setUser_pass(rs.getString("password"));
				user.setUser_type_name(rs.getString("usertypename"));
				user.setUser_gender(rs.getString("gender"));
				user.setUser_email(rs.getString("email"));

				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}


	public User getUser(int user_id) throws Exception {

		try {
			String sql = "select userid, username, usertypeid, email, gender, password From public.tbluser WHERE userid=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("userid"));
				user.setUser_name(rs.getString("username"));
				user.setUser_pass(rs.getString("password"));
				user.setUser_type(rs.getInt("usertypeid"));
				user.setUser_gender(rs.getString("gender"));
				user.setUser_email(rs.getString("email"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return null;
	}

	public boolean addAdminUser(User u) throws Exception {
		try {
			String sql = "INSERT INTO public.tbluser(userid,usertypeid,username,password, email, gender) VALUES(nextval('public.seq_user'),?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);

			p.setInt(1, u.getUser_type());
			p.setString(2, u.getUser_name());
			p.setString(3, u.getUser_pass());
			p.setString(4, u.getUser_email());
			p.setString(5, u.getUser_gender());
			
			if (p.executeUpdate() > 0)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (con != null)
				con.close();
		}

		return false;
	}

	public boolean updateUser(User user) throws Exception {
		try {
			String sql = "UPDATE public.tbluser SET username=?,password=?, email=?, gender=?,usertypeid=? WHERE userid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_pass());

			pstmt.setString(3, user.getUser_email());
			pstmt.setString(4, user.getUser_gender());
			pstmt.setInt(5, user.getUser_type());
			pstmt.setInt(6, user.getUser_id());
			
			if (pstmt.executeUpdate() > 0)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}
	public boolean updateUserInfo(User user) throws Exception {
		try {
			String sql = "UPDATE public.tbluser SET username=?,password=?, gender=? WHERE userid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_pass());
			pstmt.setString(3, user.getUser_gender());
			pstmt.setInt(4, user.getUser_id());
			
			if (pstmt.executeUpdate() > 0)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public int getCountUser() throws Exception {
		try {
			String sql = "SELECT COUNT(*) FROM public.tbluser";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return 0;
	}

	public boolean deleteUser(int user_id) throws Exception {
		try {
			String sql = "DELETE FROM public.tbluser WHERE userid=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			if (p.executeUpdate() > 0)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	/**
	 * if the email existed return true otherwise return false
	 */
	public boolean searchEmail(String email) throws SQLException {
		try {
			String sql = "select count(userid) from public.tbluser where email=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)>0)return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public boolean subScribe(int category_id, int user_id) throws SQLException {
		try {
			String sql = "insert into news.tbsubscribe(subscribe_id, category_id, user_id) values(nextval('news.seq_subscribe_id'),?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, category_id);
			pstmt.setInt(2, user_id);
			if (pstmt.executeUpdate() > 0)
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public boolean updatePassword(int user_id, String password) {
		try {
			String sql = "UPDATE public.tbluser SET password=? WHERE userid=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, user_id);
			if (pstmt.executeUpdate() > 0)
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

}
