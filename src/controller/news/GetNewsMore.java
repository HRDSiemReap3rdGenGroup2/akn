package controller.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dto.News;

import com.google.gson.Gson;

public class GetNewsMore extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5909977756977092556L;

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
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			int offset=0;
			int source_id=0;
			if(req.getParameter("page")!=null){
				offset=Integer.parseInt(req.getParameter("page"));
			}
			if(req.getParameter("source_id")!=null){
				source_id=Integer.parseInt(req.getParameter("source_id"));
			}
			offset=offset*6; 
			int totalpage=new NewsDAO().getTotalPage(category_id, 6);
		
			if((offset/6)>totalpage)offset=new NewsDAO().getAllNews().size()-7;

			if(offset<0)offset=0;
			list = new NewsDAO().getNewsList(category_id,source_id ,"latest",offset,6);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			String buf = new Gson().toJson(list);
			resp.getWriter().write(buf);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
