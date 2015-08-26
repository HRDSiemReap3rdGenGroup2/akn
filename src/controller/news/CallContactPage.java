package controller.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;

public class CallContactPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4406455620440642832L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
		}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			//menu
			req.setAttribute("menu", new MenuDAO().getAllMenu());
			req.getRequestDispatcher("contact.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
