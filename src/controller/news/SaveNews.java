package controller.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SaveListDAO;
import model.dto.SaveList;
import model.dto.User;

public class SaveNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4814553479034795203L;

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
			if (req.getParameter("news_id") == null) {
				resp.getWriter().write("fail");
				return;
			}
			int news_id = Integer.parseInt(req.getParameter("news_id"));
			int user_id;
			if (req.getSession().getAttribute("user") != null) {
				user_id = ((User) req.getSession().getAttribute("user")).getUser_id();
				ArrayList<SaveList> list = new SaveListDAO()
						.getAllSavedNews(user_id);
				boolean help = true;
				for (SaveList x : list) {
					if (x.getNews_id() == news_id) {
						help = false;
					}
				}
				if (help) {
					if (new SaveListDAO().saveNews(user_id, news_id)) {
						resp.getWriter().write("success");
					}
				} else {
					resp.getWriter().write("fail");
				}
			}
		} catch (Exception e) {
			resp.getWriter().write("fail");
			e.printStackTrace();
		}
	}

}
