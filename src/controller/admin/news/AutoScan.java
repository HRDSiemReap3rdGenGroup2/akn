package controller.admin.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ScannedNewsDAO;
import model.dao.ScraptCamboReportNews;
import model.dao.ScraptFRANews;
import model.dao.ScraptKhmerNoteNews;
import model.dao.ScraptKohSontepheapNews;
import model.dao.ScraptSabayNews;
import model.dao.ScraptTheBNews;
import model.dto.NewsDTO;

/**
 * Servlet implementation class AutoScan
 */
@WebServlet("/admin/html/pages/autoscan")
public class AutoScan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoScan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request,response);
	}

	private void doPro(HttpServletRequest request, HttpServletResponse response) {
		
		while(true){
			int i=(Integer)request.getSession().getServletContext().getAttribute("autoscan");
			if(i==0){
				System.out.println("Stop Auto Scan...");
				break;
			}
			else{
				try {
					System.out.println("Start Auto Scan.....");
					Thread.sleep(i*60*1000);
					
					ArrayList<NewsDTO> allnewslist = new ArrayList<NewsDTO>();
					ArrayList<NewsDTO> news = null;
					
					news = new ScraptTheBNews().getAllCategory();
					allnewslist.addAll(news);
				
					news = new ScraptSabayNews().getAllCategory();
					allnewslist.addAll(news);
						
					news = new ScraptKohSontepheapNews().getAllCategory();
					allnewslist.addAll(news);
						
					news = new ScraptFRANews().getAllCategory();
					allnewslist.addAll(news);
					
					news = new ScraptCamboReportNews().getAllCategory();
					allnewslist.addAll(news);
					
					news = new ScraptKhmerNoteNews().getAllCategory();
					allnewslist.addAll(news);
					
					try {
						new ScannedNewsDAO().insertNews(allnewslist);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
