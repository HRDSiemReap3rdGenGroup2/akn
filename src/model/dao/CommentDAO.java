package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utilities.DBUtility;
import model.dto.Comment;

public class CommentDAO {
	private Connection con;
	public CommentDAO(){
		con = new DBUtility().getConnection();
	}
	public ArrayList<Comment> getAllComment(int news_id){
		ArrayList<Comment> list=new ArrayList<Comment>();
		try{
			String sql="Select comment_id, comment_detail, comment_date, u.user_name, u.user_img from tbcomment c inner join tbuser u on u.user_id=c.user_id  where c.news_id=?";
			PreparedStatement p=con.prepareStatement(sql);
			p.setInt(1, news_id);
			ResultSet rs=p.executeQuery();
			while(rs.next()){
				Comment c=new Comment();
				c.setComment_id(rs.getInt("comment_id"));
				c.setComment_detail(rs.getString("comment_detail"));
				c.setDate(rs.getDate("comment_date"));
				c.setNews_id(rs.getInt("news_id"));
				c.setUser_name(rs.getString("user_name"));
				c.setUser_img(rs.getString("user_image"));
				list.add(c);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return list;
	}
}
