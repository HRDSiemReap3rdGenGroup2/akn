package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dto.News;
import utilities.DBUtility;

public class NewsDAO {
	private Connection con;

	public NewsDAO() {
//		try{
//			Class.forName("org.postgresql.Driver");
//			con=DriverManager.getConnection("jdbc:postgresql://192.168.178.127:5432/dbAKN?user=postgres&password=123");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		con = new DBUtility().getConnection();
	}

	public boolean insertNews() {
		// insert into tbnews (date_insert) values (now())
		return false;
	}

	public ArrayList<News> getNewsList(int category_id) throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql="select * from tbnews where category_id=? limit 4 offset 0";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1,category_id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("news_hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public ArrayList<News> getNewsList(int category_id, int limit)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql="SELECT * FROM tbnews WHERE category_id=? ORDER BY news_id DESC LIMIT ? OFFSET 0";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, category_id);
			p.setInt(2, limit);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("news_hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public ArrayList<News> getPopNews() throws SQLException {
		return filterNews(4, 0, 0, 7);
	}

	public ArrayList<News> getLatestNews() throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql = "SELECT * FROM tbnews ORDER BY news_id DESC LIMIT 3 OFFSET 0";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("news_hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public String getNewsPath(int id) throws SQLException {
		try {
			String sql = "SELECT news_path FROM tbnews WHERE news_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getString("news_path");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return "";
	}

	public ArrayList<News> search(String s_query, List<String> category)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		List<String> l1=new ArrayList<String>();
		for(String x:category){
			l1.add(x.substring(4, 7));
		}
		category=l1;
		try {
			String sql = "select * from tbnews where lower(news_title) like '%' || lower(?) || '%'";
			if (category.size() > 1) {
				sql += " and substring(cat_code from 5 for 3) in (";
				for (int i = 0; i < category.size() - 1; i++) {
					sql += "'" + category.get(i).toString() + "',";
				}
				sql += "'" + category.get(category.size() - 1).toString() + "'";
				sql += ") limit 10 offset 0";
			} else if (category.size() == 1) {
				sql += " and substring(cat_code from 5 for 3) in (";
				for (int i = 0; i < category.size(); i++) {
					sql += "'" + category.get(i).toString() + "'";
				}
				sql += ") limit 10 offset 0";
			} else {
				sql = "select * from tbnews where lower(news_title) like '%' || lower(?) || '%' limit 10 offset 0";
			}
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, s_query);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	/**
	 * set news's hit_count=hit_count+1 where news_id=id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean read(int id) throws SQLException {
		try {
			String sql = "UPDATE tbnews SET news_hit_count=news_hit_count+1 WHERE news_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			if (p.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}
	/**
	 * 
	 * @param limit
	 * @param source
	 * @param category
	 * @param time (1, 7, 30)
	 * @throws SQLException
	 */
	public ArrayList<News> filterNews(int n, int source, int category, int time) throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql = "SELECT * FROM filterNews(?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, source);
			p.setInt(2, category);
			p.setInt(3, time);
			p.setInt(4, n);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("news_hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}
	/**
	 * 
	 * @param category_id
	 * @param limit
	 * @return
	 * @throws SQLException
	 */
	public int getTotalPage(int category_id, int limit) throws SQLException {
		try {
			String sql = "select count(*) from tbnews where category_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, category_id);
			ResultSet rs = p.executeQuery();
			if (rs.next())
				return rs.getInt(1) / limit;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}

	public ArrayList<News> getNewsList(int category_id, int limit, int offset)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		if(offset==0)offset=1;
		offset = limit * (offset - 1);
		try {
			String sql = "SELECT * FROM tbnews WHERE category_id=? ORDER BY news_id DESC LIMIT ? OFFSET ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, category_id);
			p.setInt(2, limit);
			p.setInt(3, offset);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("news_hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public boolean addNews(News news) throws Exception {
		try {
			Statement s = con.createStatement();
			ResultSet tmp = s.executeQuery("select nextval('seq_news_id')");
			int i = 0;
			if (tmp.next())
				i = tmp.getInt(1);
			else
				return false;
			String sql = "INSERT INTO tbnews(news_id,cat_code,news_title,news_desc,news_path,news_img,news_date,user_info_code) VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, i);
			pstmt.setInt(2, news.getCategory_id());
			pstmt.setString(3, news.getNews_title());
			pstmt.setString(4, news.getNews_desc());
			pstmt.setString(5, news.getNews_path() + "news?id=" + i);
			pstmt.setString(6, news.getNews_img());
			pstmt.setString(7, news.getNews_date().toString());
			pstmt.setInt(8, news.getSource_id());
			System.out.println("done!");
			if (pstmt.executeUpdate() > 0)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return false;
	}

	public ArrayList<News> getAllNews() throws Exception {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql = "SELECT n.news_id, c.category_name, n.news_title, n.news_date"
						+" FROM tbnews n"
						+" INNER JOIN tbcategory c ON c.category_id=n.category_id"
						+" ORDER BY n.news_id DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt(1));
				news.setCategory_name(rs.getString(2));
				news.setNews_title(rs.getString(3));
				news.setNews_date(rs.getDate(4));
				list.add(news);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public News getNews(int news_id) throws Exception {
		try {
			String sql = "SELECT n.news_img, n.news_id, c.category_name, n.news_title, n.news_description,"
						+" n.news_date, n.news_hit_count"
						+" FROM tbnews n"
						+" INNER JOIN tbcategory c ON c.category_id=n.category_id"
						+" WHERE n.news_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setNews_title(rs.getString("news_title"));
				news.setNews_desc(rs.getString("news_description"));
				news.setNews_date(rs.getDate("news_date"));
				news.setCategory_name(rs.getString("category_name"));
				news.setNews_img(rs.getString("news_img"));
				news.setHit_count(rs.getInt("hit_count"));
				return news;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return null;
	}

	public boolean updateNews(News news) throws Exception{
		try{
			String sql = "UPDATE tbnews SET news_title=?, news_desc=?,news_img=?, news_date=?, cat_code=? WHERE news_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, news.getNews_title());
			pstmt.setString(2, news.getNews_desc());
			pstmt.setString(3, news.getNews_img());
			pstmt.setString(4, news.getNews_date().toString());
			pstmt.setInt(5, news.getCategory_id());
			pstmt.setInt(6, news.getNews_id());
			
			if(pstmt.executeUpdate()>0)
				return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
		}
		
		return false;
	}
	public boolean deleteNews(int news_id) throws Exception {
		try {
			String sql = "DELETE FROM tbnews WHERE news_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, news_id);
			if (p.executeUpdate() > 0)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	public int getCountNews() throws Exception {
		try {
			String sql = "SELECT COUNT(*) FROM tbnews";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}

	public ArrayList<News> getTop5News() throws Exception {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql = "SELECT news_id,news_title,news_date,hit_count FROM tbnews ORDER BY hit_count DESC LIMIT 10";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt(1));
				news.setNews_title(rs.getString(2));
				news.setNews_date(rs.getDate(3));
				news.setHit_count(rs.getInt(4));
				list.add(news);
			}
			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return null;
	}

	public int getAKNnews() throws Exception {
		try {
			String sql = "select count(*) from tbnews where aknnews=1";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}

	public int getSubscriber() throws Exception {
		try {
			String sql = "SELECT count(*) FROM (select DISTINCT user_id as u FROM tbsubscribe) as t";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}

	public ArrayList<News> getNewsList(int category_id, String option)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			
			String sql="select n.news_date, n.news_id, n.news_title, n.news_description, n.news_img, n.news_path, n.news_hit_count, n.category_id, n.source_id, c.category_name, s.source_name from tbnews n inner join tbcategory c on c.category_id=n.category_id inner join tbsource s on s.source_id=n.source_id where n.category_id=?";
			if (option.equals("latest")) {
				sql += " ORDER BY news_id DESC LIMIT 4 OFFSET 0";
			} else {
				sql += " ORDER BY news_hit_count DESC LIMIT 4 OFFSET 0";
			}
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, category_id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCategory_id(rs.getInt("category_id"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getDate("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setCategory_name(rs.getString("category_name"));
				e.setSource_id(rs.getInt("source_id"));
				e.setNews_desc(rs.getString("news_description"));
				e.setHit_count(rs.getInt("news_hit_count"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public String getMediaName(int id) throws SQLException {
		try {
			String sql = "select user_info_code from tbnews where news_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return "";
	}

	public ArrayList<String> getSubscribeList(int user_id) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		try {
			String sql = "select category_id from tbsubscribe where user_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}

	public String getModuleType(String category_id) throws SQLException {
		try {
			String sql = "select module_type from tbmoduleinfo where module_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, Integer.parseInt(category_id));
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return "";
	}

	public ArrayList<News> getSavedNews(int user_id) throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String sql = "SELECT * from tbsavelist sa INNER JOIN tbnews n on n.news_id=sa.news_id where sa.user_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News n=new News();
				n.setNews_title(rs.getString("news_title"));
				n.setNews_id(rs.getInt("news_id"));
				n.setNews_path(rs.getString("news_path"));
				n.setNews_desc(rs.getString("news_description"));
				n.setHit_count(rs.getInt("hit_count"));
				n.setNews_img(rs.getString("news_img"));
				n.setNews_date(rs.getDate("news_date"));
				list.add(n);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
}
