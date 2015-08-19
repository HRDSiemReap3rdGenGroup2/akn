package model.dto;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", cat_code=" + cat_code
				+ ", user_info_code=" + user_info_code + ", news_title="
				+ news_title + ", news_desc=" + news_desc + ", news_path="
				+ news_path + ", news_img=" + news_img + ", news_date="
				+ news_date + ", date_insert=" + date_insert + ", hit_count="
				+ hit_count + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1747541731178749434L;
	private int news_id;
	private String cat_code;
	private String user_info_code;
	private String news_title;
	private String news_desc;
	private String news_path;
	private String news_img;
	private String news_date;
	private Date date_insert;
	private int hit_count;
	private String module_type;
	// just added
	private String module_code;
	private int status;

	public String getModule_code() {
		return module_code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public String getModule_type() {
		return module_type;
	}

	public void setModule_type(String module_type) {
		this.module_type = module_type;
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
	 * @return the cat_code
	 */
	public String getCat_code() {
		return cat_code;
	}

	/**
	 * @param cat_code
	 *            the cat_code to set
	 */
	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
	}

	/**
	 * @return the user_info_code
	 */
	public String getUser_info_code() {
		return user_info_code;
	}

	/**
	 * @param user_info_code
	 *            the user_info_code to set
	 */
	public void setUser_info_code(String user_info_code) {
		this.user_info_code = user_info_code;
	}

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
	public String getNews_date() {
		return news_date;
	}

	/**
	 * @param news_date
	 *            the news_date to set
	 */
	public void setNews_date(String news_date) {
		this.news_date = news_date;
	}

	public Date getDate_insert() {
		return date_insert;
	}

	public void setDate_insert(Date date_insert) {
		this.date_insert = date_insert;
	}

	public int getHit_count() {
		return hit_count;
	}

	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}

}
