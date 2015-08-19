package controller.admin.news;

import java.io.IOException;

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
		int id = Integer.parseInt(request.getParameter("id"));
		String path = request.getParameter("path");
		String khmer = request.getParameter("khmer");
		String english = request.getParameter("english");
		String category = request.getParameter("category");
		String date = request.getParameter("mydate");
		String khmercontent = request.getParameter("khmercontent");
		String englishcontent = request.getParameter("englishcontent");
		System.out.println(path);
		System.out.println(id);
		System.out.println(khmer);
		System.out.println(english);
		System.out.println(category);
		System.out.println(date);
		System.out.println(khmercontent);
		System.out.println(englishcontent);
		
		News news = new News();
		
		news.setNews_id(id);
		news.setNews_title(khmer);
		news.setNews_desc(khmercontent);
		news.setNews_img(path);
		news.setNews_date(date);
		news.setCat_code(category);
		news.setNews_path(request.getContextPath()+"/");
		news.setUser_info_code("B010000");
		try {
			boolean status = new NewsDAO().updateNews(news);
			if(status){
				response.getWriter().write("success");
				response.sendRedirect("listnews");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
