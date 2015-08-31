package model.dao;
import java.io.IOException;
import java.util.ArrayList;

import model.dto.NewsDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ScraptKohSontepheapNews {
	final String DOMAIN = "http://kohsantepheapdaily.com.kh";
	final String PREFIX = "K";
	String BUSINESS_URL = "http://kohsantepheapdaily.com.kh/category/classify/";
	
	public ArrayList<NewsDTO> getAllCategory(){
		ArrayList<NewsDTO> allCategory = new ArrayList<NewsDTO>();
		
		ArrayList<NewsDTO> business = getKohSantepheapNews(BUSINESS_URL, "អចលនទ្រព្យ");
		
		allCategory.addAll(business);
		
		return allCategory;
	}
	
	private ArrayList<NewsDTO> getKohSantepheapNews(String NEWS_URL, String category_name){
		
		int category_id = 0, source_id = 0;;
		try {
			//get category id
			category_id = new CategoryDAO().getCategoryId(category_name);
			//get source id
			source_id = new SourceDAO().getSourceId("KOH");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		ArrayList<NewsDTO> listKohNews = new ArrayList<NewsDTO>();
		try {
			Document document = Jsoup.connect(NEWS_URL).get();
			Elements news_row = document.select(".articleItem");
			for(Element news:news_row){
				//get news thumbnail
				Elements img = news.select("img");
				String news_img = img.attr("src");
				
				//get news link
				Elements text = news.select(".articleText");
				Elements link = text.select("a");
				String news_link = DOMAIN+link.attr("href");
				
				//get news id from link
				String koh_news_id = PREFIX + news_link.substring(news_link.lastIndexOf("/")+1, news_link.lastIndexOf(".")); 
					
				//get news title
				String news_title = link.text();
				
				//get news date
				String news_date = text.select(".date").text();
				
				//get news description
				Elements desc = text.select("p:not(.date)");	
				String news_desc = desc.text();
				
				NewsDTO kohNew = new NewsDTO();
				kohNew.setNews_source_id(source_id);
				kohNew.setNews_source("Koh Sontepheap");
				kohNew.setNews_category_id(category_id);
				kohNew.setNews_category(category_name);
				kohNew.setNews_id(koh_news_id);
				kohNew.setNews_title(news_title);
				kohNew.setNews_desc(news_desc);
				kohNew.setNews_img(news_img);
				kohNew.setNews_link(news_link);
				kohNew.setNews_date(news_date);
				
				listKohNews.add(kohNew);
			}
			return listKohNews;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		ArrayList<NewsDTO> list = new ScraptKohSontepheapNews().getKohSantepheapNews("http://kohsantepheapdaily.com.kh/category/classify/", "អចលនទ្រព្យ");
		System.out.println(list);
	}
}
