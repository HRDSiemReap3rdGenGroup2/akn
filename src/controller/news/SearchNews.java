package controller.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.MenuDAO;
import model.dao.NewsDAO;
import model.dao.SaveListDAO;
import model.dto.News;
import model.dto.SaveList;
import model.dto.User;

public class SearchNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4600741998239897517L;

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
			req.setCharacterEncoding("UTF-8");
			ArrayList<Integer> category_list = new ArrayList<Integer>();
			ArrayList<News> list = new ArrayList<News>();
			
			Enumeration<String> category_list_name = req.getParameterNames();
			while (category_list_name.hasMoreElements()) {
				String tmp=category_list_name.nextElement();
				if (tmp.contains("category"))
					category_list.add(Integer.parseInt(req.getParameter(tmp)));
			}
			String s_query = "";
			s_query = req.getParameter("s_query");
			req.setAttribute("s_query", s_query);

			//menu
			req.setAttribute("menu", new MenuDAO().getAllMenu());
			
			req.setAttribute("filter", new CategoryDAO().getCategoryName(category_list));

			list = new NewsDAO().search(s_query, category_list);
			req.setAttribute("result", list);
			
			java.util.ArrayList<model.dto.News> l = new NewsDAO().getPopNews();
			req.setAttribute("popularnews", l);
			
			// resp.setContentType("application/json");
			// resp.setCharacterEncoding("utf-8");
			// String buf= new Gson().toJson(list);
			// resp.getWriter().write(buf);

			if (req.getSession().getAttribute("user") != null
					|| (req.getSession().getAttribute("user") != "")) {
				if (req.getSession().getAttribute("user_id") != null) {
					int user_id = ((User) req.getSession().getAttribute("user")).getUser_id();
					ArrayList<SaveList> user_savedlist = new SaveListDAO()
							.getAllSavedNews(user_id);
					req.setAttribute("user_savedlist", user_savedlist);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("search.jsp").forward(req, resp);
	}
}// end class
