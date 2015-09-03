package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import model.dto.NewsDTO;
import utilities.DBUtility;

public class ScannedNewsDAO {
		Connection con = null;
		
		public ScannedNewsDAO(){
			con = new DBUtility().getConnection();
		}
	
		//news database
		public boolean insertNews(ArrayList<NewsDTO> listnews)throws Exception{
			try{
				String sql = "INSERT INTO news.tbnews(news_id, news_title, news_description,"+
						" news_img, news_path, news_code, category_id, source_id)"+
						" VALUES(nextval('news.seq_news_id'),?,?,?,?,?,?,?)";
				
				Collections.reverse(listnews);
				
				for(NewsDTO news:listnews){
					PreparedStatement p = con.prepareStatement(sql);
					p.setString(1, news.getNews_title());
					p.setString(2, news.getNews_desc());
					p.setString(3, news.getNews_img());
					p.setString(4, news.getNews_link());
					p.setString(5, news.getNews_id()); //news code
					p.setInt(6, news.getNews_category_id());
					p.setInt(7, news.getNews_source_id());
					if(exist(news.getNews_id())==false){
						p.executeUpdate();
					}
					p.close();
				}
				return true;
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(con!=null)
					con.close();
			}
			return false;
		}
		
		private boolean exist(String news_code) throws Exception{
			try{
				String sql = "SELECT news_code FROM news.tbnews WHERE news_code=?";
				PreparedStatement p = con.prepareStatement(sql);
				p.setString(1, news_code);
				ResultSet rs = p.executeQuery();
				
				while(rs.next()){
					if(rs.getString("news_code")!=null){
						return true;
					}
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return false;
		}
		
}
