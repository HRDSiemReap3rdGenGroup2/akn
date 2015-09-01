package controller.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.MenuDAO;
import model.dao.NewsDAO;
import model.dao.SaveListDAO;
import model.dto.SaveList;
import model.dto.User;

public class NewsPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3567706261745264415L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}
	private void doPro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try{
			resp.setIntHeader("Refresh", 60 * 5);
			int category_id = Integer.parseInt(req.getParameter("id"));
			
			java.util.ArrayList<model.dto.News> list = new NewsDAO().getPopNews();
			req.setAttribute("popularnews", list);

			// paging
			int pagenumber = new NewsDAO().getTotalPage(category_id, 6);
			req.setAttribute("page_number", pagenumber);
			int current_page = 1;
			if (req.getParameter("page") == null
					|| req.getParameter("page") == "") {
				current_page = 1;
			} else {
				current_page = Integer.parseInt(req.getParameter("page"));
			}
			if (current_page > pagenumber)
				current_page = pagenumber;
			req.setAttribute("current_page", current_page);

			//menu
			req.setAttribute("menu", new MenuDAO().getAllMenu());
			// user
			if (req.getSession().getAttribute("ka_user") != null && (req.getSession().getAttribute("ka_user") != "")) {
				User user = (User) req.getSession().getAttribute("ka_user");
				ArrayList<SaveList> user_savedlist = new SaveListDAO()
						.getAllSavedNews(user.getUser_id());
				req.setAttribute("user_savedlist", user_savedlist);

				req.setAttribute("subscribe_list", new NewsDAO().getSubscribeList(user.getUser_id()));
			}
			// category_id
			req.setAttribute("category_id",category_id);
			list = new NewsDAO().getNewsList(category_id, 6, current_page);
			req.setAttribute("list", list);
			req.setAttribute("title", new CategoryDAO().getCategoryName(category_id));
			req.setAttribute("title_id", category_id);
			req.getRequestDispatcher("/category.jsp").forward(req, resp);
			
		}catch(Exception e){
			e.printStackTrace();
			resp.sendRedirect("home");
		}
	}

}
