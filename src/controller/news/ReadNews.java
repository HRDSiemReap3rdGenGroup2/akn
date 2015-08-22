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

public class ReadNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4868460463686477046L;

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
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			// user
			if (req.getSession().getAttribute("user") != null
					&& (req.getSession().getAttribute("user") != "")) {
				int user_id = ((User) req.getSession().getAttribute("user")).getUser_id();
				ArrayList<SaveList> user_savedlist = new SaveListDAO()
						.getAllSavedNews(user_id);
				req.setAttribute("user_savedlist", user_savedlist);
			}
						
			String news_path = new NewsDAO().getNewsPath(id);
			new NewsDAO().read(id);// increase number of hit count of this news
									// by 1
			req.setAttribute("url", news_path);
			if (!news_path.contains("http")) {
				java.util.ArrayList<model.dto.News> list = new NewsDAO()
						.getPopNews();
				req.setAttribute("popularnews", list);
				//menu
				req.setAttribute("menu", new MenuDAO().getAllMenu());
				req.setAttribute("news", new NewsDAO().getNews(id));
				req.getRequestDispatcher("/news.jsp").forward(req, resp);
				;
			} else {
				resp.sendRedirect(news_path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
