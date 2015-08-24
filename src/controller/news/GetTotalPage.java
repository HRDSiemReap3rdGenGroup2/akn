package controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.dao.NewsDAO;

public class GetTotalPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8196672927931911458L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		try{
			int category_id=Integer.parseInt(req.getParameter("category_id"));
			int totalpage=new NewsDAO().getTotalPage(category_id, 6);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			String buf = new Gson().toJson(totalpage);
			resp.getWriter().write(buf);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
