package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.User;

public class LoginUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5455134197149605806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String username = req.getParameter("email");
			String password = req.getParameter("password");
			if (username == null)
				username = "";
			if (password == null)
				password = "";
			User u;
			if ((u = new model.dao.UserDAO().login(username, password)) != null) {
				req.getSession().setAttribute("user", u.getUser_name());
				req.getSession().setAttribute("user_id", u.getUser_id());
				req.getSession().setAttribute("user_type", u.getUser_type());
			} else {
				resp.getWriter().write("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("failed");
		}
	}
}
