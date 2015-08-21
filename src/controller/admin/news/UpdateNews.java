package controller.admin.news;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import model.dao.CategoryDAO;
import model.dao.NewsDAO;
import model.dao.SourceDAO;
import model.dto.Category;
import model.dto.News;
import model.dto.Source;

/**
 * Servlet implementation class UpdateNews
 */
public class UpdateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int news_id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Category> list;
		try {
			response.setCharacterEncoding("utf-8");
			list = new CategoryDAO().getAllCategory();
			request.setAttribute("category", list);
			
			ArrayList<Source> source = new SourceDAO().getAllSource();
			request.setAttribute("source", source);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			News news = new NewsDAO().getNewsForUpdate(news_id);
			news.setStatus(1);
			request.setAttribute("news", news);
			request.getRequestDispatcher("addnews.jsp").forward(request, response);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
