package model.dao;
import java.io.IOException;
import java.util.ArrayList;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraptCamboReportNews {

	//private final String DOMAIN = "http://news.sabay.com";
	private final String PREFIX = "CR";
	private final String TECHNOLOGY_URL = "http://cambo-report.com/science";
	private final String HEALTH_URL = "http://cambo-report.com/health";
	private final String KNOWLEDGE_URL = "http://cambo-report.com/general-knowledge";
		
	
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> technology = getNewsDTO(TECHNOLOGY_URL,"បច្ចេកវិទ្យា");
		ArrayList<NewsDTO> health = getNewsDTO(HEALTH_URL,"សុខភាព");
		ArrayList<NewsDTO> knowledge = getNewsDTO(KNOWLEDGE_URL,"ចំណេះដឹង");
		
		allCategory.addAll(technology);
		allCategory.addAll(health);
		allCategory.addAll(knowledge);
		
		return allCategory;
	}
	
	private ArrayList<NewsDTO> getNewsDTO(String NEWS_URL, String category_name){
		
		int category_id = 0, source_id = 0;;
		try {
			category_id = new CategoryDAO().getCategoryId(category_name);
			source_id = new SourceDAO().getSourceId("CAMBOREPORT");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Document document = Jsoup.connect(NEWS_URL).timeout(10*1000).get();
			ArrayList<NewsDTO> listCRNEWS = new ArrayList<NewsDTO>();

			//get all the listed news by category
			Elements news_row = document.select(".article");
			
			for(Element news:news_row){
				String thums = news.select("a > img").attr("src");
				
				String title = news.select("h3").text();
				
				String url = news.select("h3 > a").attr("href");
				
				String code = PREFIX+url.substring(url.lastIndexOf('/')+1);
				
				String description = news.select("p:not(.publish)").text();
				description = description.substring(0,description.lastIndexOf("...")-1);
				
				String date = news.select(".right").text();
				
				
				NewsDTO crNews = new NewsDTO();
				crNews.setNews_category_id(category_id);
				crNews.setNews_source_id(source_id);
				crNews.setNews_id(code);
				crNews.setNews_img(thums);
				crNews.setNews_title(title);
				crNews.setNews_link(url);
				crNews.setNews_desc(description);
				crNews.setNews_category(category_name);
				crNews.setNews_source("Cambo Report");
				crNews.setNews_date(date);
				
				listCRNEWS.add(crNews);
				
			}
			return listCRNEWS;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
