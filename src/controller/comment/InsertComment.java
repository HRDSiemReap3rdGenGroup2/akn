package controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CommentDAO;
import model.dto.Comment;
import model.dto.User;

public class InsertComment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5266522318858016904L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	
	private void doPro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try{
			int news_id=Integer.parseInt(req.getParameter("news_id"));
			String comment_detail=req.getParameter("comment_detail");
			int user_id = ((User)req.getSession().getAttribute("user")).getUser_id();
			Comment c=new Comment();
			c.setUser_id(user_id);
			c.setNews_id(news_id);
			c.setComment_detail(comment_detail);
			if(new CommentDAO().insertComment(c)){
				resp.getWriter().write("success");
			}
			else{
				resp.getWriter().write("error");
			}
		}catch(Exception e){
			resp.getWriter().write("error");
			e.printStackTrace();
		}
	}
}
