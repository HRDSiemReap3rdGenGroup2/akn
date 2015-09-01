package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;
import model.dao.UserDAO;
import model.dto.User;

public class UserPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3258514143419052021L;

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
			//menu
			req.setAttribute("menu", new MenuDAO().getAllMenu());
			
			if(req.getSession().getAttribute("ka_user")!=null){
			int user_id = ((User) req.getSession().getAttribute("ka_user")).getUser_id();
			User u=new UserDAO().getUser(user_id);
			req.getSession().setAttribute("user", u);
			
			req.getRequestDispatcher("user.jsp").forward(req, resp);
			}else{
				resp.sendRedirect(req.getContextPath());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
