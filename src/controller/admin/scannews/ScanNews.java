package controller.admin.scannews;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ScannedNewsDAO;
import model.dao.ScraptKohSontepheapNews;
import model.dao.ScraptSabayNews;
import model.dao.ScraptTheBNews;
import model.dto.NewsDTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class ScanNews
 */
public class ScanNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanNews() {
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
		
		String source = request.getParameter("source");
		System.out.println(source);
		String arr[] = source.split(",");
		System.out.println(arr.length);
		ArrayList<NewsDTO> allnewslist = new ArrayList<NewsDTO>();
		ArrayList<NewsDTO> news = null;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i].contains("THEBNEWS")){
				news = new ScraptTheBNews().getAllCategory();
				allnewslist.addAll(news);
			}
			else if(arr[i].contains("SABAY")){
				news = new ScraptSabayNews().getAllCategory();
				allnewslist.addAll(news);
				
			}else if(arr[i].contains("KOH")){
				news = new ScraptKohSontepheapNews().getAllCategory();
				allnewslist.addAll(news);
			}
		}
		
		try {
			System.out.println("TEst");
			boolean status = new ScannedNewsDAO().insertNews(allnewslist);
			if(status)
				System.out.println("success!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String allnews= new Gson().toJson(allnewslist);
		response.getWriter().write(allnews);
		
	}

}
