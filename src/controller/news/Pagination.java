package controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;

import com.google.gson.Gson;

public class Pagination extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1717871369850857989L;

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

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		String category = req.getParameter("category");
		int numberofpage;
		try {
			numberofpage = new NewsDAO().getTotalPage(category, 6);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			String buf = new Gson().toJson(numberofpage);
			resp.getWriter().write(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
