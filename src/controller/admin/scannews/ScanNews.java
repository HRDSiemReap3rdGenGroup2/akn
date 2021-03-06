package controller.admin.scannews;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ScannedNewsDAO;
import model.dao.ScraptCamboReportNews;
import model.dao.ScraptFRANews;
import model.dao.ScraptKhmerNoteNews;
import model.dao.ScraptKohSontepheapNews;
import model.dao.ScraptPostKhmerNews;
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
		String arr[] = source.split(",");
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
				
			}else if(arr[i].contains("CAMBOREPORT")){
				news = new ScraptCamboReportNews().getAllCategory();
				allnewslist.addAll(news);
				
			}else if(arr[i].contains("KHMERNOTE")){
				news = new ScraptKhmerNoteNews().getAllCategory();
				allnewslist.addAll(news);
				
			}else if(arr[i].contains("POSTKHMER")){
				news = new ScraptPostKhmerNews().getAllCategory();
				allnewslist.addAll(news);
			
			}else if(arr[i].contains("RFA")){
				news = new ScraptFRANews().getAllCategory();
				allnewslist.addAll(news);
			}
		}
		
		try {
			new ScannedNewsDAO().insertNews(allnewslist);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String allnews= new Gson().toJson(allnewslist);
		response.getWriter().write(allnews);
		
	}

}
