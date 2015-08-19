package model.dto;

public class SaveList {
	private int id;
	private int user_id;
	private int news_id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

}
