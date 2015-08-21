package model.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class News implements Serializable {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = -1747541731178749434L;
	private int news_id;
	private int category_id;
	private String category_name;
	private int source_id;
	private String source_name;
	private String news_title;
	private String news_desc;
	private String news_path;
	private String news_img;
	private Date news_date;
	private int hit_count;
	private Timestamp news_date_timestamp;
	
	private int status;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", category_id=" + category_id
				+ ", category_name=" + category_name + ", source_id="
				+ source_id + ", news_title=" + news_title + ", news_desc="
				+ news_desc + ", news_path=" + news_path + ", news_img="
				+ news_img + ", news_date=" + news_date + ", hit_count="
				+ hit_count + "]";
	}

	/**
	 * @return the news_id
	 */
	public int getNews_id() {
		return news_id;
	}

	/**
	 * @param news_id
	 *            the news_id to set
	 */
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	/**
	 * @return the user_info_code
	 */
	/**
	 * @return the news_title
	 */
	public String getNews_title() {
		return news_title;
	}

	/**
	 * @param news_title
	 *            the news_title to set
	 */
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	/**
	 * @return the news_desc
	 */
	public String getNews_desc() {
		return news_desc;
	}

	/**
	 * @param news_desc
	 *            the news_desc to set
	 */
	public void setNews_desc(String news_desc) {
		this.news_desc = news_desc;
	}

	/**
	 * @return the news_path
	 */
	public String getNews_path() {
		return news_path;
	}

	/**
	 * @param news_path
	 *            the news_path to set
	 */
	public void setNews_path(String news_path) {
		this.news_path = news_path;
	}

	/**
	 * @return the news_img
	 */
	public String getNews_img() {
		return news_img;
	}

	/**
	 * @param news_img
	 *            the news_img to set
	 */
	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}

	/**
	 * @return the news_date
	 */
	public Date getNews_date() {
		return news_date;
	}

	/**
	 * @param news_date
	 *            the news_date to set
	 */
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}

	public int getHit_count() {
		return hit_count;
	}

	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSource_id() {
		return source_id;
	}

	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getNews_date_timestamp() {
		return news_date_timestamp;
	}

	public void setNews_date_timestamp(Timestamp news_date_timestamp) {
		this.news_date_timestamp = news_date_timestamp;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	


}
