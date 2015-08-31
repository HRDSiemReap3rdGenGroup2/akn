package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dao.UserDAO;
import model.dto.News;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int allnews; int allusers; 
		try {
			allnews = new NewsDAO().getCountNews();
			request.setAttribute("countnews", allnews);
			
			allusers= new UserDAO().getCountUser();
			request.setAttribute("countuser", allusers);
			
			ArrayList<News> topnews = new NewsDAO().getTop5News(); 
			request.setAttribute("topnews", topnews);
			
			int aknnews = new NewsDAO().getAKNnews();
			request.setAttribute("aknnews", aknnews);
			
			int subscriber = new NewsDAO().getSubscriber();
			request.setAttribute("subscriber", subscriber);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
