package model.dto;

import java.util.Date;

public class Comment {
	private int comment_id;
	private int user_id;
	private String user_name;
	private Date date;
	private String user_img;
	private int news_id;
	private String comment_detail;
	/**
	 * @return the comment_id
	 */
	public int getComment_id() {
		return comment_id;
	}
	/**
	 * @param comment_id the comment_id to set
	 */
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the news_id
	 */
	public int getNews_id() {
		return news_id;
	}
	/**
	 * @param news_id the news_id to set
	 */
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	/**
	 * @return the comment_detail
	 */
	public String getComment_detail() {
		return comment_detail;
	}
	/**
	 * @param comment_detail the comment_detail to set
	 */
	public void setComment_detail(String comment_detail) {
		this.comment_detail = comment_detail;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
}
