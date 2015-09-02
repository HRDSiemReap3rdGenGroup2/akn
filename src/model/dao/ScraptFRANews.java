package model.dao;
import java.io.IOException;
import java.util.ArrayList;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraptFRANews {

	//private final String DOMAIN = "http://news.sabay.com";
	private final String PREFIX = "RFA";
	private final String POLITIC_URL = "http://www.rfa.org/khmer/news/politics/story_archive";
		
	
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> politic = getNewsDTO(POLITIC_URL, "នយោបាយ");
		allCategory.addAll(politic);
		
		return allCategory;
	}
	
	public ArrayList<NewsDTO> getNewsDTO(String NEWS_URL, String category_name){
		
		int category_id = 0, source_id = 0;;
		try {
			category_id = new CategoryDAO().getCategoryId(category_name);
			source_id = new SourceDAO().getSourceId("RFA");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Document document = Jsoup.connect(NEWS_URL).timeout(10*1000).get();
			ArrayList<NewsDTO> listFRA = new ArrayList<NewsDTO>();

			//get all the listed news by category
			Elements news_row = document.select(".sectionteaser");
			
			for(Element news:news_row){
				String thums = news.select("img").attr("src");
				
				String title = news.select("h2 > a").text();
				
				String url = news.select("h2 > a").attr("href");
			
				String code = PREFIX + url.substring(url.lastIndexOf("-")+1,url.lastIndexOf("."));
				
				String date = news.select("span").text();
				
				String description = news.select("br").first().nextSibling().toString();
			

				NewsDTO rfaNews = new NewsDTO();
				rfaNews.setNews_category_id(category_id);
				rfaNews.setNews_category(category_name);
				rfaNews.setNews_source_id(source_id);
				rfaNews.setNews_source("RFA");
				rfaNews.setNews_title(title);
				rfaNews.setNews_link(url);
				rfaNews.setNews_id(code);
				rfaNews.setNews_date(date);
				rfaNews.setNews_desc(description);
				rfaNews.setNews_img(thums);
				
				listFRA.add(rfaNews);
				
			}
			return listFRA;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
