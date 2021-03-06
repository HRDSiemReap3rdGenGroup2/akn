package controller.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;
import model.dao.NewsDAO;
import model.dao.SaveListDAO;
import model.dto.SaveList;
import model.dto.User;

public class GetAllNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083663593118226740L;

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
			throws ServletException, IOException {
		try {
			resp.setIntHeader("Refresh", 60 * 5);
			java.util.ArrayList<model.dto.News> list = new NewsDAO().getPopNews();
			req.setAttribute("popularnews", list);
			list = new NewsDAO().getNewsList(7, "latest" ,0,3);
			req.setAttribute("life", list);
			list = new NewsDAO().getNewsList(8, "latest" ,0,4);
			req.setAttribute("entertainment", list);
			list = new NewsDAO().getNewsList(4, "latest" ,0,4);
			req.setAttribute("tech", list);
			list = new NewsDAO().getNewsList(1, "latest" ,0,6);
			req.setAttribute("advertise", list);
			req.setAttribute("latestnews", new NewsDAO().getLatestNews());

			//menu
			req.setAttribute("menu", new MenuDAO().getAllMenu());
			// user
			if (req.getSession().getAttribute("ka_user") != null
					&& (req.getSession().getAttribute("ka_user") != "")) {
				User user = (User) req.getSession().getAttribute("ka_user");
				ArrayList<SaveList> user_savedlist = new SaveListDAO()
						.getAllSavedNews(user.getUser_id());
				req.setAttribute("user_savedlist", user_savedlist);
			}

			req.getRequestDispatcher("homepage.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
