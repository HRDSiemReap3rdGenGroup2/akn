package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utilities.DBUtility;
import model.dto.Comment;

public class CommentDAO {
	private Connection con;
	public CommentDAO(){
		con = new DBUtility().getConnection();
	}
	public ArrayList<Comment> getAllComment(int news_id) throws SQLException{
		ArrayList<Comment> list=new ArrayList<Comment>();
		try{
			String sql="Select comment_id, comment_detail, comment_date, u.user_name, u.user_image from tbcomment c inner join tbuser u on u.user_id=c.user_id  where c.news_id=?";
			PreparedStatement p=con.prepareStatement(sql);
			p.setInt(1, news_id);
			ResultSet rs=p.executeQuery();
			while(rs.next()){
				Comment c=new Comment();
				c.setComment_id(rs.getInt("comment_id"));
				c.setComment_detail(rs.getString("comment_detail"));
				c.setDate(rs.getDate("comment_date"));
				c.setUser_name(rs.getString("user_name"));
				c.setUser_img(rs.getString("user_image"));
				list.add(c);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)con.close();
		}
		return list;
	}
	public boolean insertComment(Comment c) throws SQLException{
		try{
			String sql="insert into tbcomment values(nextval('seq_comment_id'),?, now(),?,?)";
			PreparedStatement p =con.prepareStatement(sql);
			p.setString(1, c.getComment_detail());
			p.setInt(2, c.getUser_id());
			p.setInt(3, c.getNews_id());
			if(p.executeUpdate()>0)return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)con.close();
		}
		return false;
	}
}
