package controller.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dao.SaveListDAO;
import model.dto.News;
import model.dto.SaveList;

import com.google.gson.Gson;

public class GetPopNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4513839376691183277L;

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
		doPro(req, resp);
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
		doPro(req, resp);
	}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<News> list = new ArrayList<News>();
		try {
			if (req.getParameter("time") != null) {
				String time = req.getParameter("time");
				list = new NewsDAO().filterNews(4, "%", "%", time);
			} else {
				String category = req.getParameter("category");
				String option = req.getParameter("option");
				list = new NewsDAO().getNewsList(category, option);
			}
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			String buf = new Gson().toJson(list);
			resp.getWriter().write(buf);

			// user
			if (req.getSession().getAttribute("user") != null
					&& (req.getSession().getAttribute("user") != "")) {
				int user_id = (Integer) req.getSession().getAttribute("user_id");
				ArrayList<SaveList> user_savedlist = new SaveListDAO()
						.getAllSavedNews(user_id);
				req.setAttribute("user_savedlist", user_savedlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
