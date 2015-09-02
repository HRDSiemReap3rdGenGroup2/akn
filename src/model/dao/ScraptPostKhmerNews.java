package model.dao;
import java.io.IOException;
import java.util.ArrayList;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraptPostKhmerNews {

	//private final String DOMAIN = "http://news.sabay.com";
	private final String PREFIX = "PK";
	private final String SPORT_URL = "http://www.postkhmer.com/%E1%9E%80%E1%9E%B8%E1%9E%A1%E1%9E%B6";
	private final String ENTERTAINT_URL = "http://www.postkhmer.com/%E1%9E%87%E1%9E%B8%E1%9E%9C%E1%9E%B7%E1%9E%8F%E1%9E%80%E1%9E%98%E1%9F%92%E1%9E%9F%E1%9E%B6%E1%9E%93%E1%9F%92%E1%9E%8F";
	private final String ECONOMIC_URL = "http://www.postkhmer.com/%E1%9E%9F%E1%9F%81%E1%9E%8A%E1%9F%92%E1%9E%8B%E1%9E%80%E1%9E%B7%E1%9E%85%E1%9F%92%E1%9E%85";
	private final String ESTATE_URL = "http://www.postkhmer.com/%E1%9E%94%E1%9F%89%E1%9E%BB%E1%9E%9F%E1%9F%92%E1%9E%8F%E1%9E%B7%E1%9F%8D%E2%80%8B-%E1%9E%A2%E1%9E%85%E1%9E%9B%E1%9E%93%E1%9E%91%E1%9F%92%E1%9E%9A%E1%9E%96%E1%9F%92%E1%9E%99";
		
	/**
	 * get all news of all categories
	 * return {@link ArrayList} {@lin
	 * k NewsDTO}
	 */
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> sport = getNewsDTO(SPORT_URL, "កីឡា");
		ArrayList<NewsDTO> estate = getNewsDTO(ESTATE_URL, "អចលនទ្រព្យ");
		ArrayList<NewsDTO> economic = getNewsDTO(ECONOMIC_URL, "សេដ្ឋកិច្ច");
		ArrayList<NewsDTO> entertain = getNewsDTO(ENTERTAINT_URL, "កម្សាន្ត");
		
		allCategory.addAll(sport);
		allCategory.addAll(estate);
		allCategory.addAll(economic);
		allCategory.addAll(entertain);
		
		return allCategory;
	}
	
	
	/**
	 * return all news for specific category by URL
	 * return {@link ArrayList} {@link NewsDTO}
	 */
	public ArrayList<NewsDTO> getNewsDTO(String NEWS_URL, String category_name){
		
		int category_id = 0, source_id = 0;;
		try {
			category_id = new CategoryDAO().getCategoryId(category_name);
			source_id = new SourceDAO().getSourceId("POSTKHMER");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Document document = Jsoup.connect(NEWS_URL).timeout(10*1000).get();
			ArrayList<NewsDTO> listPostKhmer = new ArrayList<NewsDTO>();

			
			//get all the listed news by category
			Elements news_row = document.select(".category");
			
			for(Element news:news_row){
				String thums = news.select("img").attr("src");
				
				String title = news.select("h3 > a").text();
				
				String url = news.select("h3 > a").attr("href");
				
				String code = PREFIX + url.substring(url.lastIndexOf('/')+1);
				
				String date = news.select(".posted-date").text();
				
				String description = news.select(".summary > p").text();
				
				NewsDTO pkNews = new NewsDTO();
				pkNews.setNews_category_id(category_id);
				pkNews.setNews_category(category_name);
				pkNews.setNews_source_id(source_id);
				pkNews.setNews_source("Post Khmer");
				pkNews.setNews_id(code);
				pkNews.setNews_img(thums);
				pkNews.setNews_desc(description);
				pkNews.setNews_title(title);
				pkNews.setNews_link(url);
				pkNews.setNews_date(date);
				
				listPostKhmer.add(pkNews);
			}
			return listPostKhmer;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
