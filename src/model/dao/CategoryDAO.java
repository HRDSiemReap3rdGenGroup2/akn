package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Category;
import utilities.DBUtility;

public class CategoryDAO {
	private Connection con = null;

	public CategoryDAO() {
		con = new DBUtility().getConnection();
	}

	public ArrayList<Category> getAllCategory() throws SQLException {
		ArrayList<Category> list = new ArrayList<Category>();
		try {
			String sql = "SELECT * FROM tbcategory";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				list.add(category);
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
	public String getCategoryName(int category_id) throws SQLException{
		try{
			String sql="select category_name from tbcategory where category_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, category_id);
			ResultSet rs= p.executeQuery();
			while(rs.next()){
				return rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)con.close();
		}
		return "";
	}
	public int getCategoryId(String category_name)throws Exception{
		try {
			String sql = "SELECT category_id FROM tbcategory WHERE category_name=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, category_name);
			ResultSet rs = p.executeQuery();

			while(rs.next()){
				return rs.getInt("category_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}
	
	public boolean addCategory(Category cate) throws SQLException {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public boolean updateCategory(Category cate) throws SQLException {
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public boolean deleteCategroy(int cate_id) throws SQLException {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}
}
