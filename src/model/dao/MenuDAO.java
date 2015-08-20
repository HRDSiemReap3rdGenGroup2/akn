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

	public boolean updateMenu(Menu menu) throws Exception {
		try {
			//String sql = "UPDATE tbmenu SET index0=?, index1=?, index2=?, index3=?, index4=?, index5=?, index6=?";
		
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
}
