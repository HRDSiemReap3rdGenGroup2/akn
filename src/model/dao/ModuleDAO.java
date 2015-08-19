package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Module;
import utilities.DBUtility;

public class ModuleDAO {
	private Connection con;

	public ModuleDAO() {
		con = new DBUtility().getConnection();
	}

	public ArrayList<Module> getAllModuleType() throws SQLException {
		ArrayList<Module> list = new ArrayList<>();
		try {
			String sql = "select module_type, module_type_code from tbmoduleinfo group by module_type, module_type_code";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Module m = new Module();
				m.setModule_type(rs.getString("module_type"));
				m.setModule_type_code(rs.getString("module_type_code"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	/**
	 * 
	 * @return module name (website source name)
	 * @throws SQLException
	 */
	public ArrayList<Module> getAllModuleCode() throws SQLException {
		ArrayList<Module> list = new ArrayList<>();
		try {
			String sql = "select DISTINCT module_code from tbmoduleinfo";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Module m = new Module();
				m.setModule_type(rs.getString("module_code"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public ArrayList<Module> getAllModuleName() throws SQLException {
		ArrayList<Module> list = new ArrayList<>();
		try {
			String sql = "select module_info_code, module_name FROM tbmoduleinfo GROUP BY module_info_code, module_name";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Module m = new Module();
				m.setModule_name(rs.getString("module_name"));
				m.setModule_info_code(rs.getString("module_info_code"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public boolean addModule(Module module) throws SQLException {
		try {
			String sql = "INSERT INTO tbmoduleinfo VALUES(nextval('seq_moduleinfo'),?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "ពត៌មាន");
			pstmt.setString(2, module.getModule_name());
			pstmt.setString(3, module.getModule_type());
			pstmt.setString(4, getModuleCode());

			if (pstmt.executeUpdate() > 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	private String getModuleCode() {

		// B040 + 102
		return "B040105";
	}

	public boolean validateType(String module_type) {

		return true;
	}

	public ArrayList<String> getModuleCode(String module_type)
			throws SQLException {
		ArrayList<String> list = new ArrayList<>();
		try {
			String sql = "select module_code from tbmoduleinfo where module_type_code=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, module_type);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public ArrayList<Module> getAllModuleTypeCode() throws SQLException {
		ArrayList<Module> list = new ArrayList<>();
		try {
			String sql = "select DISTINCT module_type, module_code from tbmoduleinfo";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Module m = new Module();
				m.setModule_type(rs.getString("module_type"));
				m.setModule_code(rs.getString("module_code"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public ArrayList<Module> getAllModule() throws Exception {
		ArrayList<Module> list = new ArrayList<Module>();
		try {
			String sql = "select DISTINCT module_id, module_name, module_type FROM tbmoduleinfo";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Module module = new Module();
				module.setModule_id(rs.getInt(1));
				module.setModule_name(rs.getString(2));
				module.setModule_type(rs.getString(3));
				list.add(module);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return list;
	}

	public Module getModule(int id) throws Exception {
		try {
			String sql = "SELECT * FROM tbmoduleinfo WHERE module_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Module module = new Module();
				module.setModule_id(Integer.parseInt(rs.getString("module_id")));
				module.setModule_name(rs.getString("module_name"));
				module.setModule_type(rs.getString("module_type"));
				return module;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return null;
	}

	public boolean updateModule(Module module) throws Exception {
		try {
			String sql = "UPDATE tbmoduleinfo SET module_name=?, module_type=? WHERE module_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, module.getModule_name());
			pstmt.setString(2, module.getModule_type());
			pstmt.setInt(3, module.getModule_id());
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

	public boolean deleteModule(int module_id) throws Exception {
		try {
			String sql = "DELETE FROM tbmoduleinfo WHERE module_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, module_id);
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

	public ArrayList<Module> getAllModuleType(ArrayList<String> list_module_type)
			throws SQLException {
		ArrayList<Module> list = new ArrayList<>();
		try {
			String sql = "select module_type, module_type_code from tbmoduleinfo group by module_type, module_type_code";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Module m = new Module();
				m.setModule_type(rs.getString("module_type"));
				m.setModule_type_code(rs.getString("module_type_code"));
				for (String x : list_module_type) {
					if (x.equals(m.getModule_type_code()))
						list.add(m);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	/**
	 * 
	 * @param string
	 * @return module_id (category_id)
	 * @throws SQLException
	 */
	public int getModuleId(String string) throws SQLException {
		try {
			String sql = "select module_id FROM tbmoduleinfo WHERE module_type_code=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, string);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				return rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}

}
