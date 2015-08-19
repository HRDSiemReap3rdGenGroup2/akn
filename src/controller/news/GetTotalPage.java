package controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;

import com.google.gson.Gson;

public class GetTotalPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5684788370158615573L;

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
		try {
			String category = req.getParameter("module_type_code");
			// paging
			int pagenumber = new NewsDAO().getTotalPage(category, 4);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			String buf = new Gson().toJson(pagenumber);
			resp.getWriter().write(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
