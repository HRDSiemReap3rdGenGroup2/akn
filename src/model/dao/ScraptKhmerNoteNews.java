package model.dao;
import java.io.IOException;
import java.util.ArrayList;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraptKhmerNoteNews {

	//private final String DOMAIN = "http://news.sabay.com";
	private final String PREFIX = "KN";
	private final String SPORT_URL = "http://www.khmer-note.com/news/category/%E1%9E%80%E1%9E%B8%E1%9E%A1%E1%9E%B6";
	private final String TECHNOLOGY_URL = "http://www.khmer-note.com/news/category/technology";
	private final String SOCIAL_URL = "http://www.khmer-note.com/news/category/social-life";
	private final String KNOWLEDGE_URL = "http://www.khmer-note.com/news/category/knowlege";
		
	/**
	 * get all news of all categories
	 * return {@link ArrayList} {@lin
	 * k NewsDTO}
	 */
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> technology = getNewsDTO(TECHNOLOGY_URL, "បច្ចេកវិទ្យា");
		ArrayList<NewsDTO> sport = getNewsDTO(SPORT_URL, "កីឡា");
		ArrayList<NewsDTO> social = getNewsDTO(SOCIAL_URL, "ជីវិតនិងសង្គម");
		ArrayList<NewsDTO> knowledge = getNewsDTO(KNOWLEDGE_URL, "ចំណេះដឹង");
		
		allCategory.addAll(technology);
		allCategory.addAll(sport);
		allCategory.addAll(social);
		allCategory.addAll(knowledge);
		
		return allCategory;
	}
	
	
	/**
	 * return all news for specific category by URL
	 * return {@link ArrayList} {@link NewsDTO}
	 */
	private ArrayList<NewsDTO> getNewsDTO(String NEWS_URL, String category_name){
		
		int category_id = 0, source_id = 0;;
		try {
			category_id = new CategoryDAO().getCategoryId(category_name);
			source_id = new SourceDAO().getSourceId("KHMERNOTE");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Document document = Jsoup.connect(NEWS_URL).get();
			ArrayList<NewsDTO> listKNNEWS = new ArrayList<NewsDTO>();

			//get all the listed news by category
			Elements news_row = document.getElementsByTag("article");
			
			for(Element news:news_row){
				String thums = news.select("img").attr("src");
				
				String title = news.select(".title > a").text();
				
				String url = news.select(".title > a").attr("href");
				
				String news_code = PREFIX + url.substring(url.lastIndexOf('/')+1);				
				
				String date = news.select(".thetime").text();
				
				String description = news.select(".post-content").text();
				if(description.length()>100)
					description = description.substring(0, 150);
				else
					description = description.substring(0, description.length());
				
				NewsDTO knNews = new NewsDTO();
				knNews.setNews_category(category_name);
				knNews.setNews_category_id(category_id);
				knNews.setNews_source("Khmer Note");
				knNews.setNews_source_id(source_id);
				knNews.setNews_id(news_code);
				knNews.setNews_img(thums);
				knNews.setNews_date(date);
				knNews.setNews_link(url);
				knNews.setNews_title(title);
				knNews.setNews_desc(description);
				
				listKNNEWS.add(knNews);
				
			}
			return listKNNEWS;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
