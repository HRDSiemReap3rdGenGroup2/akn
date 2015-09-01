package controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.User;

/**
 * Servlet implementation class ActionUpdateUser
 */
public class ActionUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionUpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String username=request.getParameter("username");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		
		User user = new User();
		
		user.setUser_name(username);
		user.setUser_email(email);
		user.setUser_pass(password);
		user.setUser_gender(gender);
		user.setUser_type(usertype);
		user.setUser_id(user_id);
		
		
		try {
			new UserDAO().updateUser(user);
			
			response.sendRedirect("formuser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
