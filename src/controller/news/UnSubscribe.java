package controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dto.User;

public class UnSubscribe extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7395534540639401574L;

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
	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		try{
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			int user_id = ((User)req.getSession().getAttribute("ka_user")).getUser_id();
			if(new NewsDAO().removeSubscribe(category_id,user_id)){
				resp.getWriter().write("success");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
