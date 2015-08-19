package controller.news;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ModuleDAO;
import model.dao.NewsDAO;
import model.dao.SaveListDAO;
import model.dto.SaveList;

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
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		ArrayList<String> list_module_type = new ArrayList<String>();
		try {
			Enumeration<String> category_list = req.getParameterNames();
			while (category_list.hasMoreElements()) {
				String module_type = category_list.nextElement();
				if (module_type.contains("category"))
					list_module_type.add(req.getParameter(module_type));
			}
			java.util.ArrayList<model.dto.News> list = new NewsDAO()
					.getPopNews();
			req.setAttribute("popularnews", list);
			String s_query = "";
			s_query = req.getParameter("s_query");
			req.setAttribute("s_query", s_query);

			req.setAttribute("filter", new ModuleDAO().getAllModuleType(list_module_type));

			list = new NewsDAO().search(s_query, list_module_type);
			req.setAttribute("result", list);
			// resp.setContentType("application/json");
			// resp.setCharacterEncoding("utf-8");
			// String buf= new Gson().toJson(list);
			// resp.getWriter().write(buf);

			if (req.getSession().getAttribute("user") != null
					|| (req.getSession().getAttribute("user") != "")) {
				if (req.getSession().getAttribute("user_id") != null) {
					int user_id = (Integer) req.getSession()
							.getAttribute("user_id");
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
