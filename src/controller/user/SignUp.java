package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.User;

public class SignUp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5454658684469607060L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String confirmpassword = req.getParameter("password_c");
			if (username == "") {
				resp.getWriter().write("e2");
				return;
			}
			if (new UserDAO().searchEmail(email)) {
				resp.getWriter().write("e5");
				return;
			}
			if (!confirmpassword.equals(password)) {
				resp.getWriter().write("e3");
				return;
			}
			try {
				Integer.parseInt(req.getParameter("gender"));
			} catch (Exception e) {
				resp.getWriter().write("e4");
				return;
			}
			int gender = Integer.parseInt(req.getParameter("gender"));
			if(gender>2){
				resp.getWriter().write("e2");
				return;
			}
			User u = new User();
			u.setUser_name(username);
			u.setEmail(email);
			u.setGender(gender);
			u.setUser_pass(password);
			if (new UserDAO().addUser(u)) {
				User u2 = new model.dao.UserDAO().login(email, password);
				req.getSession().setAttribute("user", username);
				req.getSession().setAttribute("user_id", u2.getUser_id());
				resp.getWriter().write("success");
			} else {
				resp.getWriter().write("e2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("e1");
		}
	}
}
