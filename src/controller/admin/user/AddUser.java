package controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.User;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		
		String username=request.getParameter("username");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		
		User user = new User();
		
		user.setUser_name(username);
		user.setUser_email(email);
		user.setUser_pass(password);
		user.setUser_gender(gender);
		user.setUser_type(usertype);
		
		try {
			boolean status = new UserDAO().addAdminUser(user);
			if(status)
				System.out.println("success!");
			response.sendRedirect("listuser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
