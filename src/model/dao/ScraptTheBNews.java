package model.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraptTheBNews {
	private final String PREFIX = "B";
	private final String BUSINESS_URL = "http://www.thebnews.com/business/";
	private final String WORLD_URL = "http://www.thebnews.com/world-news/";
	private final String ENTERPRENEUR_URL = "http://www.thebnews.com/entrepreneur/";
	private final String TECHNOLOGY_URL = "http://www.thebnews.com/technology/";
	private final String INNOVATIVE_URL = "http://www.thebnews.com/innovative/";
	private final String LUXURY_URL = "http://www.thebnews.com/luxury/";
	
	/**
	 * get all news of all categories
	 * return {@link ArrayList} {@link NewsDTO}
	 */
	
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> business = getTheBNews(BUSINESS_URL,"ពាណិជ្ជកម្ម");
		ArrayList<NewsDTO> world = getTheBNews(WORLD_URL,"ពត៌មានពិភពលោក");
		ArrayList<NewsDTO> enterpreneur = getTheBNews(ENTERPRENEUR_URL,"សហក្រិនភាព");
		ArrayList<NewsDTO> technology = getTheBNews(TECHNOLOGY_URL,"បច្ចេកវិទ្យា");
		ArrayList<NewsDTO> innovative = getTheBNews(INNOVATIVE_URL,"ថ្មីហើយប្លែក");
		ArrayList<NewsDTO> luxury = getTheBNews(LUXURY_URL,"ស៊ីវីល័យ");
		
		allCategory.addAll(business);
		allCategory.addAll(world);
		allCategory.addAll(enterpreneur);
		allCategory.addAll(technology);
		allCategory.addAll(innovative);
		allCategory.addAll(luxury);
	
		return allCategory;
	}
	
	/**
	 * return all news for specific category by URL
	 * return {@link ArrayList} {@link NewsDTO}
	 */
	public ArrayList<NewsDTO> getTheBNews(String NEWS_URL, String category_name){
		
		ArrayList<NewsDTO> listTheBNews = new ArrayList<NewsDTO>();
		
		int category_id = 0, source_id = 0;;
		try {
			//get category id
			category_id = new CategoryDAO().getCategoryId(category_name);
			//get source id
			source_id = new SourceDAO().getSourceId("THEBNEWS");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Document document = Jsoup.connect(NEWS_URL).get();
			Elements news_row = document.select(".box");
			
			for(Element news:news_row){
				
				Elements news_img = news.getElementsByClass("thumbnail");
				String img = news_img.attr("data-src");
				
				Elements news_title = news.getElementsByClass("post_subtitle");
				String title = news_title.text();
				
				Elements news_link = news_title.select("a");
				String link = news_link.attr("href");
				
				Elements news_desc = news.getElementsByClass("post_descr");
				String desc = news_desc.text();
				
				//get news date
				//String date = null;
				if(link!=""){
					/*Document docdate = Jsoup.connect(link).get();
					Elements news_date = docdate.select(".cover-time");
					date = news_date.select("p").text();*/
					
					String specificlink = link.substring(0, link.lastIndexOf("/"));
					String thebnewsid = specificlink.substring(specificlink.lastIndexOf("/")+1);
					
					//get source code, name
					
					NewsDTO sb = new NewsDTO();
					sb.setNews_source("TheBNews");
					sb.setNews_source_id(source_id);
					
					sb.setNews_category(category_name);
					sb.setNews_category_id(category_id);
					
					sb.setNews_id(PREFIX+thebnewsid);
					sb.setNews_title(title);
					sb.setNews_desc(desc);
					sb.setNews_img(img);
					sb.setNews_date(new Date().toString());
					sb.setNews_link(specificlink);
					listTheBNews.add(sb);
				}
			}
			return listTheBNews;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
