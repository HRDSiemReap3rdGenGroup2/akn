package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.SaveList;
import utilities.DBUtility;

public class SaveListDAO {
	private Connection con;

	public SaveListDAO() {
		con = new DBUtility().getConnection();
	}

	public ArrayList<SaveList> getAllSavedNews(int user_id) throws SQLException {
		ArrayList<SaveList> list = new ArrayList<SaveList>();
		try {
			String sql = "SELECT * FROM tbsavelist WHERE user_id=?;";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				SaveList s = new SaveList();
				s.setUser_id(rs.getInt("user_id"));
				s.setNews_id(rs.getInt("news_id"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public boolean saveNews(int user_id, int news_id) throws SQLException {
		try {
			String sql = "INSERT INTO tbsavelist(savelist_id, user_id, news_id) values (nextval('seq_savelist_id'),?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			p.setInt(2, news_id);
			if (p.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}
}
