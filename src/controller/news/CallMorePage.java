package controller.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;
import model.dao.SaveListDAO;
import model.dto.SaveList;
import model.dto.User;

public class CallMorePage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4447710908789184311L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		try{
			//menu
			req.setAttribute("menu", new MenuDAO().getAllMenu());
			// user
			if (req.getSession().getAttribute("ka_user") != null && (req.getSession().getAttribute("ka_user") != "")) {
				int user_id = ((User) req.getSession().getAttribute("ka_user")).getUser_id();
				ArrayList<SaveList> user_savedlist = new SaveListDAO().getAllSavedNews(user_id);
				req.setAttribute("user_savedlist", user_savedlist);
			}
			req.getRequestDispatcher("more.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
