package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Source;
import utilities.DBUtility;

public class SourceDAO {
	private Connection con = null;
	public SourceDAO(){
		con = new DBUtility().getConnection();
	}
	
	public ArrayList<Source> getAllSource() throws Exception{
		ArrayList<Source> list = new ArrayList<Source>();
		try{
			String sql = "SELECT * FROM tbsource";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Source source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_name(rs.getString("source_name"));
				source.setSource_code(rs.getString("source_code"));
				list.add(source);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
		}
		return list;
	}
	public int getSourceId(String source_code)throws Exception{
		try{
			String sql = "SELECT source_id FROM tbsource WHERE source_code=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, source_code);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				return rs.getInt("source_id");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
		}
		return 0;
	}
	public Source getSource(int source_id)throws Exception{
		Source source = new Source();
		try{
			String sql = "SELECT * FROM tbsource WHERE source_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, source_id);
			ResultSet rs = p.executeQuery();
			if(rs.next()){
				source.setSource_id(rs.getInt(1));		
				source.setSource_name(rs.getString(2));
				source.setSource_code(rs.getString(3));		
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
		}
		return source;
	}

	public boolean addSource(Source source) throws Exception {
		try {
			String sql = "INSERT INTO tbsource VALUES(nextval('seq_source_id'),?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, source.getSource_name());
			p.setString(2, source.getSource_code());
			if (p.executeUpdate() > 0){
				System.out.println(1);
				return true;
			}
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}
	
	public boolean editSource(Source source) throws Exception {
		try {
			String sql = "Update tbsource SET source_name=?, source_code=? WHERE source_id=?;";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, source.getSource_name());
			p.setString(2, source.getSource_code());
			p.setInt(3, source.getSource_id());
			if (p.executeUpdate() > 0){
				System.out.println(1);
				return true;
			}
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}
	
	public boolean deleteSource(int source_id) {
		System.out.println(source_id);
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM tbsource WHERE source_id=?;");
			ps.setInt(1, source_id);
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
