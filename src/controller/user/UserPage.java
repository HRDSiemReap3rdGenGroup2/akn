package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dao.UserDAO;
import model.dto.News;
import model.dto.Subscribe;
import model.dto.User;

public class UserPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3258514143419052021L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		try{
			if(req.getSession().getAttribute("user_id")!=null){
			int user_id=(int) req.getSession().getAttribute("user_id");
			User u=new UserDAO().getUser(user_id);
			req.setAttribute("user", u);
			ArrayList<Subscribe> list=new ArrayList<Subscribe>();
			ArrayList<String> l=new NewsDAO().getSubscribeList(user_id);
			for(String category_id:l){
				Subscribe s=new Subscribe();
				s.setModule_id(Integer.parseInt(category_id));
				s.setModule_name(new NewsDAO().getModuleType(category_id));
				list.add(s);
			}
			req.setAttribute("subscribelist", list);
			
			ArrayList<News> ln=new ArrayList<News>();
			ln=new NewsDAO().getSavedNews(user_id);
			req.setAttribute("savedlist", ln);
			req.getRequestDispatcher("user.jsp").forward(req, resp);
			}else{
				resp.sendRedirect(req.getContextPath());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
