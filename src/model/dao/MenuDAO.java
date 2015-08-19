package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dto.Menu;
import utilities.DBUtility;

public class MenuDAO {
	private Connection con = null;

	public MenuDAO() {
		con = new DBUtility().getConnection();
	}

	public boolean updateMenu(Menu menu) throws Exception {
		try {
			String sql = "UPDATE tbmenu SET index0=?, index1=?, index2=?, index3=?, index4=?, index5=?, index6=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menu.getIndex0());
			pstmt.setString(2, menu.getIndex1());
			pstmt.setString(3, menu.getIndex2());
			pstmt.setString(4, menu.getIndex3());
			pstmt.setString(5, menu.getIndex4());
			pstmt.setString(6, menu.getIndex5());
			pstmt.setString(7, menu.getIndex6());

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

	public Menu getAllMenu() throws Exception {
		try {
			String sql = "SELECT * FROM tbmenu";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Menu menu = new Menu();
			while (rs.next()) {
				menu.setIndex0(rs.getString(1));
				menu.setIndex1(rs.getString(2));
				menu.setIndex2(rs.getString(3));
				menu.setIndex3(rs.getString(4));
				menu.setIndex4(rs.getString(5));
				menu.setIndex5(rs.getString(6));
				menu.setIndex6(rs.getString(7));
			}
			System.out.println(menu);
			return menu;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return null;
	}
}
