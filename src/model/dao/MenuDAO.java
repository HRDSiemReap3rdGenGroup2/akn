package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.Menu;
import utilities.DBUtility;

public class MenuDAO {
	private Connection con = null;

	public MenuDAO() {
		con = new DBUtility().getConnection();
	}

	public boolean updateMenu(ArrayList<Integer> category_ids) throws Exception {
		try {
			System.out.println("hello");
			System.out.println(category_ids);
			String sql = "UPDATE tbmenu SET category_id=? WHERE menu_index=?";
			int menu_index = 0;
			for(Integer category_id:category_ids){
				
				PreparedStatement p = con.prepareStatement(sql);
				p.setInt(1, category_id);
				p.setInt(2, menu_index++);
				System.out.println(category_id);
				System.out.println(menu_index);
				p.executeUpdate();
			}
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public ArrayList<Menu> getAllMenu() throws Exception {
		ArrayList<Menu> list =new ArrayList<Menu>();
		try {
			String sql = "SELECT * FROM tbmenu m inner join tbcategory c on c.category_id=m.category_id order by menu_index asc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Menu m=new Menu();
				m.setId(rs.getInt("menu_id"));
				m.setIndex(rs.getInt("category_id"));
				m.setName(rs.getString("category_name"));
				list.add(m);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}
	
	public ArrayList<Menu> getMenuUpdate() throws Exception{
		ArrayList<Menu> list =new ArrayList<Menu>();
		try {
			String sql = "SELECT m.category_id, category_name, menu_index "
					+ "FROM tbmenu m inner join tbcategory c on "
					+ "c.category_id=m.category_id order by menu_index asc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Menu m=new Menu();
				m.setIndex(rs.getInt("menu_index"));
				m.setCategory_id(rs.getInt("category_id"));
				m.setName(rs.getString("category_name"));
				list.add(m);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}
	
	
}
