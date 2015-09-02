package controller.admin.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.User;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetJsonUser
 */
public class GetJsonUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJsonUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ArrayList<User> list = new UserDAO().getAllUser2();
			
			String gString = new Gson().toJson(list);
			
			String d = "{\"data\":"+gString +"}";
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ArrayList<User> list = new UserDAO().getAllUser1();
			
			String gString = new Gson().toJson(list);
			
			String d = "{\"data\":"+gString +"}";
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
