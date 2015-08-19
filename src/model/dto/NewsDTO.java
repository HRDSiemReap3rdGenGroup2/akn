package model.dto;

import java.sql.Timestamp;

public class NewsDTO {
	
	private int news_category_id;
	private String news_category;
	private String news_id; //news code
	private String news_title;
	private String news_img;
	private String news_date;
	private String news_desc;
	private String scrapt_date;
	private String news_link;
	private String news_source;
	private int news_source_id;
	private Timestamp news_date_srcapted;
	
	public NewsDTO(){
	
	}

	public String getNews_id() {
		return news_id;
	}
	
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	
	public String getNews_category() {
		return news_category;
	}
	public void setNews_category(String news_category) {
		this.news_category = news_category;
	}

	public String getNews_link() {
		return news_link;
	}
	public void setNews_link(String news_link) {
		this.news_link = news_link;
	}
	
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_img() {
		return news_img;
	}
	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}
	public String getNews_date() {
		return news_date;
	}
	public void setNews_date(String news_date) {
		this.news_date = news_date;
	}
	public String getNews_desc() {
		return news_desc;
	}
	public void setNews_desc(String news_desc) {
		this.news_desc = news_desc;
	}
	public String getScrapt_date() {
		return scrapt_date;
	}
	public void setScrapt_date(String scrapt_date) {
		this.scrapt_date = scrapt_date;
	}

	public String getNews_source() {
		return news_source;
	}

	public void setNews_source(String news_source) {
		this.news_source = news_source;
	}

	public int getNews_source_id() {
		return news_source_id;
	}

	public void setNews_source_id(int news_source_id) {
		this.news_source_id = news_source_id;
	}

	public int getNews_category_id() {
		return news_category_id;
	}

	public void setNews_category_id(int news_category_id) {
		this.news_category_id = news_category_id;
	}

	public Timestamp getNews_date_srcapted() {
		return news_date_srcapted;
	}

	public void setNews_date_srcapted(Timestamp news_date_srcapted) {
		this.news_date_srcapted = news_date_srcapted;
	}

}
