package controller.news;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;
import model.dao.NewsDAO;
import model.dao.SaveListDAO;
import model.dto.SaveList;
import model.dto.User;

public class ReadNews extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4868460463686477046L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			// user
			if (req.getSession().getAttribute("ka_user") != null
					&& (req.getSession().getAttribute("ka_user") != "")) {
				int user_id = ((User) req.getSession().getAttribute("ka_user")).getUser_id();
				ArrayList<SaveList> user_savedlist = new SaveListDAO()
						.getAllSavedNews(user_id);
				req.setAttribute("user_savedlist", user_savedlist);
			}
						
			String news_path = new NewsDAO().getNewsPath(id);
			
			boolean help=false;
			Cookie ck[]=req.getCookies();  
			StringBuilder sb=new StringBuilder();
			InetAddress address = InetAddress.getLocalHost();
            //InetAddress address = InetAddress.getByName("192.168.46.53");

            /*
             * Get NetworkInterface for the current host and then read the
             * hardware address.
             */
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                    	sb.append(String.format("%02X ", mac[i]));
                    }
                    for(int i=0;i<ck.length;i++){  
                    	if(ck[i].getName().equalsIgnoreCase("user_address"+id) && ck[i].getValue().equalsIgnoreCase(sb.toString())){
                    		help=true;
                    	}
           			}  
                } else {
                	help=true;
                }
            } else {
            	help=true;
            }
			
			if(!help){
				Cookie c=new Cookie("user_address"+id,sb.toString());
				c.setMaxAge(60*60*24);
				resp.addCookie(c);
				new NewsDAO().read(id);// increase number of hit count of this news by 1
			}
			req.setAttribute("url", news_path);
			if (!news_path.contains("http")) {
				java.util.ArrayList<model.dto.News> list = new NewsDAO().getPopNews();
				req.setAttribute("popularnews", list);
				//menu
				req.setAttribute("menu", new MenuDAO().getAllMenu());
				req.setAttribute("news", new NewsDAO().getNews(id));
				req.getRequestDispatcher("/news.jsp").forward(req, resp);
				;
			} else {
				resp.sendRedirect(news_path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
