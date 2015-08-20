package controller.news;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dto.News;

import com.google.gson.Gson;

public class FilterNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4673597184364540744L;

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
		ArrayList<News> list;
		try {
			int n = 0;
			try {
				n = Integer.parseInt(req.getParameter("n"));
			} catch (Exception e) {
				n = 5;
			}
			int source = Integer.parseInt(req.getParameter("source"));
			int category = Integer.parseInt(req.getParameter("category"));
			int time = Integer.parseInt(req.getParameter("time"));
			list = new NewsDAO().filterNews(n, source, category, time);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			String buf = new Gson().toJson(list);
			resp.getWriter().write(buf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
