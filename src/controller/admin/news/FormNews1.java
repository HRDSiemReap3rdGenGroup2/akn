package controller.admin.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.dto.News;

/**
 * Servlet implementation class FormNews1
 */
public class FormNews1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormNews1() {
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
		String path = request.getParameter("path");
		String khmer = request.getParameter("khmer");
		String category = request.getParameter("category");
		String date = request.getParameter("mydate");
		String khmercontent = request.getParameter("khmercontent");
		String englishcontent = request.getParameter("englishcontent");
	
		System.out.println(path);
		System.out.println(khmer);
		System.out.println(category);
		System.out.println(date);
		System.out.println(khmercontent);
		System.out.println(englishcontent);
		
		News news = new News();
		news.setNews_title(khmer);
		news.setNews_desc(khmercontent);
		news.setNews_img(path);
		news.setNews_date(date);
		news.setCat_code(category);
		news.setNews_path(request.getContextPath()+"/");
		news.setUser_info_code("B010000");
		try {
			boolean status = new NewsDAO().addNews(news);
			if(status)
				response.getWriter().write("success");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
