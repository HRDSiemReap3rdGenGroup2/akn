package controller.admin.news;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dto.News;

/**
 * Servlet implementation class ActionUpdateNews
 */
public class ActionUpdateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionUpdateNews() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		int id = Integer.parseInt(request.getParameter("id"));
		String path = request.getParameter("path");
		String khmer = request.getParameter("khmer");
		int category_id = Integer.parseInt(request.getParameter("category"));
		String date = request.getParameter("mydate");
		String khmercontent = request.getParameter("khmercontent");
		int source_id=6;
		
		
		News news = new News();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		news.setNews_id(id);
		news.setNews_title(khmer);
		news.setNews_desc(khmercontent);
		news.setNews_img(path);
		news.setNews_date(formatter.parse(date));
		news.setCategory_id(category_id);
		news.setNews_path(request.getContextPath()+"/");
		news.setSource_id(source_id);
		try {
			boolean status = new NewsDAO().updateNews(news);
			if(status){
				response.getWriter().write("success");
				response.sendRedirect("listnews");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
