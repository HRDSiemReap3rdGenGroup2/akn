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
		con = new DBUtility().getConnection();
	}

	public boolean insertNews() {
		// insert into tbnews (date_insert) values (now())
		return false;
	}

	public ArrayList<News> getNewsList(String category) throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String s1 = "select module_code from tbmoduleinfo where module_type_code=?";
			PreparedStatement p1 = con.prepareStatement(s1);
			p1.setString(1, category);
			ResultSet r1 = p1.executeQuery();
			String sql = "SELECT * FROM tbnews WHERE cat_code in ('";
			while (r1.next()) {
				sql += r1.getString(1) + "','";
			}
			sql += "') ORDER BY news_id DESC LIMIT 4 OFFSET 0";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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

	public ArrayList<News> getNewsList(String category, int limit)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String s1 = "select module_code from tbmoduleinfo where module_type_code=?";
			PreparedStatement p1 = con.prepareStatement(s1);
			p1.setString(1, category);
			ResultSet r1 = p1.executeQuery();
			String sql = "SELECT * FROM tbnews WHERE cat_code in ('";
			while (r1.next()) {
				sql += r1.getString(1) + "','";
			}
			sql += "') ORDER BY news_id DESC LIMIT ? OFFSET 0";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, limit);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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

	public ArrayList<News> getPopNews() throws SQLException {
		return filterNews(4, "%", "%", "monthly");
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
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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
			String sql = "UPDATE tbnews SET hit_count=hit_count+1 WHERE news_id=?";
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
	 * @param media
	 *            (module info code)
	 * @param category
	 *            (module type code)
	 * @param time
	 *            (today, weekly, monthly)
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<News> filterNews(int n, String media, String category,
			String time) throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		int t = 1;
		if (time.equalsIgnoreCase("today"))
			t = 1;
		if (time.equalsIgnoreCase("weekly"))
			t = 7;
		if (time.equalsIgnoreCase("monthly"))
			t = 30;
		try {
			String sql = "select * from tbnews n "
					+ "INNER JOIN tbmoduleinfo m on m.module_code=n.cat_code "
					+ "WHERE m.module_info_code like ? and "
					+ "m.module_type_code like ? and "
					+ "n.date_insert BETWEEN (date(now()) - ?) and date(now()) "
					+ "ORDER BY n.hit_count DESC " + "LIMIT ? OFFSET 0";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, media);
			p.setString(2, category);
			p.setInt(3, t);
			p.setInt(4, n);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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

	public int getTotalPage(String category, int limit) throws SQLException {
		try {
			String s1 = "select module_code from tbmoduleinfo where module_type_code=?";
			PreparedStatement p1 = con.prepareStatement(s1);
			p1.setString(1, category);
			ResultSet r1 = p1.executeQuery();
			String sql = "select count(*) from tbnews where cat_code in ('";
			while (r1.next()) {
				sql += r1.getString(1) + "','";
			}
			sql += "')";
			PreparedStatement p = con.prepareStatement(sql);
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

	public ArrayList<News> getNewsList(String category, int limit, int offset)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		if(offset==0)offset=1;
		offset = limit * (offset - 1);
		try {
			String s1 = "select module_code from tbmoduleinfo where module_type_code=?";
			PreparedStatement p1 = con.prepareStatement(s1);
			p1.setString(1, category);
			ResultSet r1 = p1.executeQuery();
			String sql = "SELECT * FROM tbnews WHERE cat_code in ('";
			while (r1.next()) {
				sql += r1.getString(1) + "','";
			}
			sql += "') ORDER BY news_id DESC LIMIT ? OFFSET ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, limit);
			p.setInt(2, offset);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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
			pstmt.setString(2, news.getCat_code());
			pstmt.setString(3, news.getNews_title());
			pstmt.setString(4, news.getNews_desc());
			pstmt.setString(5, news.getNews_path() + "news.jsp?id=" + i);
			pstmt.setString(6, news.getNews_img());
			pstmt.setString(7, news.getNews_date());
			pstmt.setString(8, news.getUser_info_code());
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
			String sql = "SELECT news_id, module_type,news_title,news_date FROM tbnews n INNER JOIN tbmoduleinfo m ON m.module_code=n.cat_code order by news_id desc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt(1));
				news.setModule_type(rs.getString(2));
				news.setNews_title(rs.getString(3));
				news.setNews_date(rs.getString(4));
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
			String sql = "SELECT news_img, news_id, module_code,module_type,news_title,news_desc,news_date,hit_count FROM tbnews n INNER JOIN tbmoduleinfo m ON m.module_code=n.cat_code WHERE news_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setNews_title(rs.getString("news_title"));
				news.setNews_desc(rs.getString("news_desc"));
				news.setNews_date(rs.getString("news_date"));
				news.setModule_type(rs.getString("module_type"));
				news.setModule_code(rs.getString("module_code"));
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
			pstmt.setString(4, news.getNews_date());
			pstmt.setString(5, news.getCat_code());
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
				news.setNews_date(rs.getString(3));
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

	public ArrayList<News> getNewsList(String category, String option)
			throws SQLException {
		ArrayList<News> list = new ArrayList<News>();
		try {
			String s1 = "select module_code from tbmoduleinfo where module_type_code=?";
			PreparedStatement p1 = con.prepareStatement(s1);
			p1.setString(1, category);
			ResultSet r1 = p1.executeQuery();
			String sql = "SELECT * FROM tbnews n INNER JOIN tbmoduleinfo m on n.cat_code=m.module_code WHERE cat_code in ('";
			while (r1.next()) {
				sql += r1.getString(1) + "','";
			}
			if (option.equals("latest")) {
				sql += "') ORDER BY news_id DESC LIMIT 4 OFFSET 0";
			} else {
				sql += "') ORDER BY hit_count DESC LIMIT 4 OFFSET 0";
			}
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				News e = new News();
				e.setNews_id(rs.getInt("news_id"));
				e.setCat_code(rs.getString("cat_code"));
				e.setNews_title(rs.getString("news_title"));
				e.setNews_date(rs.getString("news_date"));
				e.setNews_img(rs.getString("news_img"));
				e.setNews_path(rs.getString("news_path"));
				e.setModule_type(rs.getString("module_type"));
				e.setUser_info_code(rs.getString("user_info_code"));
				e.setNews_desc(rs.getString("news_desc"));
				e.setDate_insert(rs.getDate("date_insert"));
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
				n.setNews_desc(rs.getString("news_desc"));
				n.setHit_count(rs.getInt("hit_count"));
				n.setNews_img(rs.getString("news_img"));
				n.setNews_date(rs.getString("news_date"));
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
