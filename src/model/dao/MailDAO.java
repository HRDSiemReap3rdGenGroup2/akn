package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.dto.Mail;
import model.dto.NewsDTO;
import utilities.DBUtility;

public class MailDAO {
	private Connection con = null;

	public MailDAO() {
		con = new DBUtility().getConnection();
	}

	public boolean mySendMail(String subject, String content) throws Exception {
		ArrayList<Mail> listmail = new ArrayList<Mail>();
		try {
			String sql = "SELECT user_email FROM news.tbuser";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Mail mail = new Mail();
				mail.setToemail(rs.getString("user_email"));
				listmail.add(mail);
				System.out.println(listmail);
			}
			sendMail(listmail, subject, content);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return false;
	}

	/*
	 * public static void main(String[] args) { ArrayList<Mail> mailList = new
	 * ArrayList<Mail>(); new MailDAO().sendMail(mailList);
	 * System.out.println("success"); }
	 */
	public boolean sendMail(ArrayList<Mail> mailList, String subject,
			String content) {
		System.out.println(1);
		Properties p = System.getProperties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		System.out.println(2);
		// p.setProperty("mail.smtp.host",host);
		Session s = Session.getInstance(p, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("rathphearun168@gmail.com",
						"Patgpgdaptm1994");
			}
		});
		System.out.println(3);
		try {
			Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress("rathphearun168@gmail.com"));

			for (Mail mail : mailList) {
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(mail.getToemail()));

				message.setSubject(subject);
				message.setText(content);

				Transport.send(message);
				System.out.println(4);
			}
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean sendMail(String email, String subject, String content) {
		System.out.println(1);
		Properties p = System.getProperties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		System.out.println(2);
		// p.setProperty("mail.smtp.host",host);
		Session s = Session.getInstance(p, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("rathphearun168@gmail.com",
						"Patgpgdaptm1994");
			}
		});
		System.out.println(3);
		try {
			Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress("rathphearun168@gmail.com"));
			
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));

			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);
			System.out.println(4);
			
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean sendToSubscriber(){
		
		ArrayList<Integer> userid = getUserId();
		 
		for(int id:userid){
			
			ArrayList<Integer> allcateid = getSubscribeCategory(id);
			String email = getUserEmail(id);
			System.out.println(email);
			for(int cid:allcateid){
				ArrayList<NewsDTO> news = getNewsPath(cid);
				String content = "\n";
				for(NewsDTO n:news){
					content += "\nTitle : " + n.getNews_title();
					content += "\nLink : " + n.getNews_link()+"\n";
				}
				System.out.println(content);
				sendMail(email, "News Update...", content);
			}
		}
		return false;
	}
	
	private String getUserEmail(int user_id){
		try{
			String sql = "SELECT DISTINCT user_email FROM news.tbsubscribe WHERE user_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				return rs.getString("user_email");
			}
		
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			
			
		}
		return null;
	}
	private ArrayList<Integer> getUserId(){
		ArrayList<Integer> allid = new ArrayList<Integer>();
		try{
			String sql = "SELECT user_id FROM news.tbsubscribe";
			PreparedStatement p =con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				allid.add(rs.getInt("user_id"));
			}
			return allid;
			
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			
		}
		return allid;
	}
	private ArrayList<Integer> getSubscribeCategory(int user_id){
		
		ArrayList<Integer> allcategory = new ArrayList<Integer>();
		try {
			String sql = "SELECT category_id FROM news.tbsubscribe WHERE user_id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				allcategory.add(rs.getInt("category_id"));
			}	
			return allcategory;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}
		return allcategory;
	}
	
	private ArrayList<NewsDTO> getNewsPath(int category_id){
		
		ArrayList<NewsDTO> news_path = new ArrayList<NewsDTO>();
		try{
			String sql = "SELECT news_title, news_path FROM news.tbnews WHERE category_id=? LIMIT 10";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, category_id);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				NewsDTO news = new NewsDTO();
				news.setNews_title(rs.getString("news_title"));
				news.setNews_link(rs.getString("news_path"));
				news_path.add(news);
			}
			return news_path;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return news_path;
	}
	
	public static void main(String[] args) {
		new MailDAO().sendToSubscriber();
	}
}
