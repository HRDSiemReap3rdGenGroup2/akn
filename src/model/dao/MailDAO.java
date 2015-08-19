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
import utilities.DBUtility;

public class MailDAO {
	private Connection con = null;

	public MailDAO() {
		con = new DBUtility().getConnection();
	}

	public boolean mySendMail(String subject, String content) throws Exception {
		ArrayList<Mail> listmail = new ArrayList<Mail>();
		try {
			String sql = "SELECT user_email FROM tbuser";
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

}
