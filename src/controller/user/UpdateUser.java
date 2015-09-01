package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.User;

public class UpdateUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4485506281902023355L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try{
			int user_id=((User) req.getSession().getAttribute("ka_user")).getUser_id();
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			if(password.contains("*****")){
				User tmp=new UserDAO().getUser(user_id);
				password=tmp.getUser_pass();
			}
			String gender=req.getParameter("gender");
			User u=new User();
			u.setUser_id(user_id);
			u.setUser_name(username);
			u.setUser_pass(password);
			u.setUser_gender(gender);
			if(new UserDAO().updateUserInfo(u)){
				resp.getWriter().write("success");
			}else{
				resp.getWriter().write("error");
			}
		}catch(Exception e){
			resp.getWriter().write("error");
			e.printStackTrace();
		}
	}

}
