package model.dao;

import java.io.IOException;
import java.util.ArrayList;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraptSabayNews {

	//private final String DOMAIN = "http://news.sabay.com";
	private final String PREFIX = "S";
	private final String SPORT_URL = "http://news.sabay.com.kh/topics/sport";
	private final String LIFE_URL = "http://news.sabay.com.kh/topics/life";
	private final String ENTERTAINTMENT_URL = "http://news.sabay.com.kh/topics/entertainment";
	private final String TECHNOLOGY_URL = "http://news.sabay.com.kh/topics/technology";
	
	/**
	 * get all news of all categories
	 * return {@link ArrayList} {@lin
	 * k NewsDTO}
	 */
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> sportList = getNewsDTO(SPORT_URL,"កីឡា");
		ArrayList<NewsDTO> lifeList = getNewsDTO(LIFE_URL,"ជីវិតនិងសង្គម");
		ArrayList<NewsDTO> entertainttList = getNewsDTO(ENTERTAINTMENT_URL,"កម្សាន្ត");
		ArrayList<NewsDTO> technologyList = getNewsDTO(TECHNOLOGY_URL,"បច្ចេកវិទ្យា");
		
		allCategory.addAll(sportList);
		allCategory.addAll(lifeList);
		allCategory.addAll(entertainttList);
		allCategory.addAll(technologyList);
		
		return allCategory;
	}
	
	
	/**
	 * return all news for specific category by URL
	 * return {@link ArrayList} {@link NewsDTO}
	 */
	public ArrayList<NewsDTO> getNewsDTO(String NEWS_URL, String category_name){
		
		int category_id = 0, source_id = 0;;
		try {
			//get category id
			category_id = new CategoryDAO().getCategoryId(category_name);
			//get source id
			source_id = new SourceDAO().getSourceId("SABAY");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Document document = Jsoup.connect(NEWS_URL).timeout(10*1000).get();
			ArrayList<NewsDTO> listSabayList = new ArrayList<NewsDTO>();

			//get news category
			Elements page_title = document.getElementsByClass("page_title");
			String news_category = page_title.text();
			
			//get all the listed news by category
			Elements news_row = document.select(".row .article");
			
			for(Element news:news_row){
				//get news title
				String news_title = news.select("a[href]").text();
				
				//get news image thumnail
				Elements thumnail = news.select("img[src]");
				String news_img = thumnail.attr("src");
				
				//get news link
				Elements link = news.select("a[href]");			
				String news_link = link.attr("href");
				
				//get news id
				String news_id = news_link.substring(news_link.lastIndexOf("/")+1);
				
				//get news description
				String news_desc = news.select(".text").text();
				
				//get news date
				String news_date = news.select(".cmt-date").text();
				news_date = news_date.substring(news_date.indexOf("/")+2);
				
				//put it in arraylist of news
				NewsDTO sb = new NewsDTO();
				sb.setNews_source_id(source_id);
				sb.setNews_source("​​​SABAY");
				sb.setNews_category_id(category_id);
				sb.setNews_category(category_name);
				sb.setNews_category(news_category);
				sb.setNews_id(PREFIX+news_id);
				sb.setNews_title(news_title);
				sb.setNews_desc(news_desc);
				sb.setNews_img(news_img);
				sb.setNews_date(news_date);
				sb.setNews_link(news_link);
				
				listSabayList.add(sb);
			}
			return listSabayList;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
