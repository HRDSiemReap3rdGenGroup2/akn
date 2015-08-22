package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

public class DeleteUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2822135095579917491L;

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
			int user_id = (Integer) req.getSession().getAttribute("user_id");
			if(new UserDAO().deleteUser(user_id)){
				req.getSession().removeAttribute("user");
				req.getSession().removeAttribute("user_id");
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
