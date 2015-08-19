package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
}
