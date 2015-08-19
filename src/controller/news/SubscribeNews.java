package controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

public class SubscribeNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2005620149713512456L;

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

	private void doPro(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			if (req.getParameter("category_id") == null) {
				resp.getWriter().write("fail");
				return;
			}
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			int user_id;
			if (req.getSession().getAttribute("user_id") != null) {
				user_id = (Integer) req.getSession().getAttribute("user_id");
				new UserDAO().subScribe(category_id, user_id);
				resp.getWriter().write("success");
			}
		} catch (Exception e) {
			resp.getWriter().write("fail");
			e.printStackTrace();
		}
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

}
